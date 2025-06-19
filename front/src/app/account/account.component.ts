import {Component, OnInit} from '@angular/core';
import {AccountService} from "./services/account.service";
import {ActivatedRoute} from "@angular/router";
import {delay, take} from "rxjs";
import {Statement} from "./models/statement.model";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  statement: Statement | undefined;
  errorMessage: string | undefined;
  loading = true;

  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.loadAccountBalance();
  }

  deposit(amount: number) {
    this.accountService.deposit(this.extractIdFromUrl(), amount)
      .pipe(take(1))
      .subscribe(() => this.loadAccountBalance(),
        (error) => this.errorMessage = error);
  }

  withdraw(amount: number) {
    this.accountService.withdraw(this.extractIdFromUrl(), amount)
      .pipe(take(1))
      .subscribe(() => this.loadAccountBalance(),
        (error) => this.errorMessage = error);
  }

  private loadAccountBalance() {
    this.loading = true;
    this.accountService.getStatement(this.extractIdFromUrl())
      .pipe(take(1), delay(500))
      .subscribe((statement) => this.statement = statement,
        (error) => this.errorMessage = error,
        () => this.loading = false);
  }

  private extractIdFromUrl(): number {
    const id = this.activatedRoute.snapshot.paramMap.get('id');
    if (id === null) {
      return 0;
    } else {
      return parseInt(id, 10);
    }
  }
}
