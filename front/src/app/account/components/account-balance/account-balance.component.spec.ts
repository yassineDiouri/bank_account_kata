import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountBalanceComponent } from './account-balance.component';

describe('AccountBalanceComponent', () => {
  let component: AccountBalanceComponent;
  let fixture: ComponentFixture<AccountBalanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccountBalanceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AccountBalanceComponent);
    fixture.detectChanges();
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
