import {TestBed} from '@angular/core/testing';

import {AccountService} from './account.service';
import {HttpClientTestingModule, HttpTestingController} from "@angular/common/http/testing";
import {environment} from "../../../environments/environment";

describe('AccountService', () => {
  let service: AccountService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(AccountService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should throw Error for undefined arg id', (done) => {
    service.getBalance(undefined).subscribe({
      next: () => {
        fail('Expected an error, but got a value');
      },
      error: (err) => {
        expect(err).toBeTruthy();
        expect(err.message).toBe('Invalid id');
        done();
      }
    });
  });

  it('deposit should call http client for accounts url', () => {
    service.deposit(1, 100).subscribe(() => {});
    const req = httpMock.expectOne(`${environment.apiBaseUrl}${environment.accountsPath}/1`);
    expect(req.request.method).toBe('PUT');
  });

  [undefined, null].forEach(id => {
    it(`deposit should throw Error for ${id} arg id`, (done) => {
      service.deposit(id as any, 100).subscribe({
        next: () => {
          fail('Expected an error, but got a value');
        },
        error: (err) => {
          expect(err).toBeTruthy();
          done();
        }
      });
    });
  });

  [undefined, null].forEach(amount => {
    it(`deposit should throw Error for ${amount} arg amount`, (done) => {
      service.deposit(1, amount as any).subscribe({
        next: () => {
          fail('Expected an error, but got a value');
        },
        error: (err) => {
          expect(err).toBeTruthy();
          done();
        }
      });
    });
  });
});
