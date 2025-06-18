import { TestBed } from '@angular/core/testing';

import { AccountService } from './account.service';
import {HttpClientTestingModule} from "@angular/common/http/testing";

describe('AccountService', () => {
  let service: AccountService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    service = TestBed.inject(AccountService);
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
});
