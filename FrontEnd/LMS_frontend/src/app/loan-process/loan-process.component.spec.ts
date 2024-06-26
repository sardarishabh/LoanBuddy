import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanProcessComponent } from './loan-process.component';

describe('LoanProcessComponent', () => {
  let component: LoanProcessComponent;
  let fixture: ComponentFixture<LoanProcessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanProcessComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoanProcessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
