import {Component, Input} from '@angular/core';
import {Transaction} from "../../models/transaction.model";

@Component({
  selector: 'app-account-statement',
  templateUrl: './account-statement.component.html',
  styleUrls: ['./account-statement.component.scss']
})
export class AccountStatementComponent {

  @Input() transactions!: Transaction[];
}
