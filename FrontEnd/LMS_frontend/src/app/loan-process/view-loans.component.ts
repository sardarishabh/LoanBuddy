import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoanProcessService } from './loan-process.service';
import { LoanApplication } from './loanApplication';

@Component({
  selector: 'app-view-loans',
  templateUrl: './view-loans.component.html',
  styleUrls: ['./view-loans.component.css'],
})
export class ViewLoansComponent implements OnInit {
  loanApplications: LoanApplication[] = [];
  loanStatus!: string;

  memType = localStorage.getItem('memType');
  Id = localStorage.getItem('Id');
  memId = Number(this.Id);

  constructor(
    private processService: LoanProcessService,
    private router: Router
  ) {}

  ngOnInit(): void {

    if (localStorage.getItem('ILI') === 'false') {
      this.router.navigate(['/login']);
      alert('you are not logged in...');
    }

    this.processService
      .viewLoanApplications()
      .subscribe((data: any) => (this.loanApplications = data));
  }

  onChange(applicationId: any, loanStatus: any): void {
    console.log(applicationId, loanStatus);

    this.processService
      .alterLoanStatus({applicationId, loanStatus})
      .subscribe((data: any) => (this.loanApplications = data));

      window.location.reload();
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
