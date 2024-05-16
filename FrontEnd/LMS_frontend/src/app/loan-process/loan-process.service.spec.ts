import { TestBed } from '@angular/core/testing';

import { LoanProcessService } from './loan-process.service';

describe('LoanProcessService', () => {
  let service: LoanProcessService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoanProcessService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
