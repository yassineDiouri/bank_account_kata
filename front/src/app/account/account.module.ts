import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { AccountComponent } from './account.component';
import {AccountBalanceComponent} from "./components/account-balance/account-balance.component";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    AccountComponent,
    AccountBalanceComponent
  ],
  imports: [
    CommonModule,
    AccountRoutingModule,
    HttpClientModule
  ]
})
export class AccountModule { }
