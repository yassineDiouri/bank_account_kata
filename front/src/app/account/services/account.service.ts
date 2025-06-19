import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {environment} from "../../../environments/environment";
import {Statement} from "../models/statement.model";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private readonly http: HttpClient) {
  }

  getStatement(id: number) : Observable<Statement> {
    if (id === undefined || id === null) {
      return throwError(() => new Error('Invalid id'));
    }
    return this.http.get<Statement>(`${environment.apiBaseUrl}${environment.accountsPath}/${id}`);
  }

  deposit(id: number, amount: number): Observable<void> {
    if (id === undefined || id === null) {
      return throwError(() => new Error('Invalid id'));
    }
    if (!amount || amount <= 0) {
      return throwError(() => new Error('Invalid amount'));
    }
    return this.http.put<void>(`${environment.apiBaseUrl}${environment.accountsPath}/${id}`, amount);
  }

  withdraw(id: number, amount: number): Observable<void> {
    if (id === undefined || id === null) {
      return throwError(() => new Error('Invalid id'));
    }
    if (!amount || amount <= 0) {
      return throwError(() => new Error('Invalid amount'));
    }
    return this.http.post<void>(`${environment.apiBaseUrl}${environment.accountsPath}/${id}`, amount);
  }
}
