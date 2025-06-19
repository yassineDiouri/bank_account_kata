import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private readonly http: HttpClient) {
  }

  getBalance(id: number) : Observable<number> {
    if (id === undefined || id === null) {
      return throwError(() => new Error('Invalid id'));
    }
    return this.http.get<number>(`${environment.apiBaseUrl}${environment.accountsPath}/${id}`);
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
}
