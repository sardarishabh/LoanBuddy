import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loan } from '../loan/loan';
import { LoanService } from '../loan/loan.service';
import { Member } from '../member/member';
import { MemberService } from '../member/member.service';
import { LoanProcessService } from './loan-process.service';
import { LoanApplication } from './loanApplication';

@Component({
  selector: 'app-loan-application',
  templateUrl: './loan-application.component.html',
  styleUrls: ['./loan-application.component.css'],
})
export class LoanApplicationComponent implements OnInit {
  applicationId!: number;
  memberId!: number;
  loanId!: number;
  modeOfPayment!: string;
  loanAmount!: number;
  loanDuration!: number;
  purpose!: string;
  loanStatus!: string;
  loanStatusDef = 'Pending';
  member: Member = new Member();
  loans: Loan[] = [];
  name: any;
  userName = localStorage.getItem('userName');

  constructor(
    private loanprocess: LoanProcessService,
    private memberService: MemberService,
    private loanService: LoanService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('ILI') === 'false') {
      this.router.navigate(['/login']);
      alert('you are not logged in...');
    }

    this.memberService
      .getMemberByUserName(localStorage.getItem('userName'))
      .subscribe((data) => {
        console.log(data);
        this.member = data;
      });

    this.loanService.getLoans().subscribe((data: any) => (this.loans = data));
  }

  onSubmit(loanApp: LoanApplication) {
    this.loanprocess.applyLoan(loanApp).subscribe((data) => {
      console.log(data);
    });
    alert(
      'Application Submitted! Please check status on "View Loan Applications"'
    );
    this.router.navigate(['/dashboard']);
  }

  onCancel() {
    this.router.navigate(['/dashboard']);
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
