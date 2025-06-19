import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, of, throwError} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private readonly http: HttpClient) {
  }

  getBalance(id: number | undefined) : Observable<number> {
    if (id === undefined) {
      return throwError(() => new Error('Invalid id'));
    }
    return this.http.get<number>(`${environment.apiBaseUrl}${environment.accountsPath}/${id}`);
  }

  deposit(id: number, amount: number): Observable<void> {
    if (id === undefined || id === null) {
      return throwError(() => new Error('Invalid id'));
    }
    if (amount || amount <= 0) {
      return throwError(() => new Error('Invalid amount'));
    }
    return of();
  }
}
