import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AccountComponent} from './account.component';
import {AccountService} from "./services/account.service";
import {ActivatedRoute} from "@angular/router";
import {of} from "rxjs";
import {Statement} from "./models/statement.model";

describe('AccountComponent', () => {
  let component: AccountComponent;
  let accountService: jasmine.SpyObj<AccountService>;
  let fixture: ComponentFixture<AccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AccountComponent],
      providers: [
        {provide: AccountService, useValue: jasmine.createSpyObj('AccountService', ['getStatement'])},
        {
          provide: ActivatedRoute, useValue: {
            snapshot: {
              paramMap: {
                get: (_: string) => '1'
              },
            }
          }
        },
      ]
    })
      .compileComponents();

    accountService = TestBed.inject(AccountService) as jasmine.SpyObj<AccountService>;
    fixture = TestBed.createComponent(AccountComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    accountService.getStatement.and.returnValue(of({} as Statement));
    fixture.detectChanges();
    expect(component).toBeTruthy();
  });
});
