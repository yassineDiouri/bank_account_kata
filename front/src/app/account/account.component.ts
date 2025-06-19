import {Component, OnInit} from '@angular/core';
import {AccountService} from "./services/account.service";
import {ActivatedRoute} from "@angular/router";
import {delay, take} from "rxjs";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  balance: number | undefined;
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

  private loadAccountBalance() {
    this.loading = true;
    this.accountService.getBalance(this.extractIdFromUrl())
      .pipe(take(1), delay(500))
      .subscribe((balance) => this.balance = balance,
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
