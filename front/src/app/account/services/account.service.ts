import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";

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
    return this.http.get<number>(`http://localhost:8080/api/accounts/${id}`);
  }
}
