import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-account-operations',
  templateUrl: './account-operations.component.html',
  styleUrls: ['./account-operations.component.scss']
})
export class AccountOperationsComponent {

  @Output() deposit: EventEmitter<number> = new EventEmitter();
  @Output() withdraw: EventEmitter<number> = new EventEmitter();

  public amount = 0;

  depositClick() {
    this.deposit.emit(this.amount);
  }

  withdrawClick() {
    this.withdraw.emit(this.amount);
  }
}
