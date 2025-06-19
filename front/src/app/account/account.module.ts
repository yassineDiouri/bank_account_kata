import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { AccountComponent } from './account.component';
import {AccountBalanceComponent} from "./components/account-balance/account-balance.component";
import {HttpClientModule} from "@angular/common/http";
import { AccountOperationsComponent } from './components/account-operations/account-operations.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AccountComponent,
    AccountBalanceComponent,
    AccountOperationsComponent
  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    HttpClientModule,
    FormsModule
  ]
})
export class AccountModule { }
