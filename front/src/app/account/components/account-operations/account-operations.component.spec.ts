import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AccountOperationsComponent} from './account-operations.component';
import {FormsModule} from "@angular/forms";

describe('AccountOperationsComponent', () => {
  let component: AccountOperationsComponent;
  let fixture: ComponentFixture<AccountOperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AccountOperationsComponent],
      imports: [FormsModule]
    }).compileComponents();

    fixture = TestBed.createComponent(AccountOperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
