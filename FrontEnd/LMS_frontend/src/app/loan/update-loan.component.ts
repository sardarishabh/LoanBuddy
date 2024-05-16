import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Loan } from './loan';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-update-loan',
  templateUrl: './update-loan.component.html',
  styleUrls: ['./update-loan.component.css'],
})
export class UpdateLoanComponent implements OnInit {
  loan: Loan = new Loan;
  temp: any;
  id: any;
  memType = localStorage.getItem('memType');
  constructor(
    private loanService: LoanService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['loanId'];
    console.log(this.id);
    this.loanService.getLoanById(this.id).subscribe((data) => {
      this.loan = data;
    });
  }

  onSubmit(loan: Loan) {
    this.temp=loan;
    this.loanService.updateLoan(this.id, this.temp).subscribe((data) => {
      console.log(data);

    });
    this.router.navigate(['/loans']);
  }

  onCancel() {
    this.router.navigate(['/loans']);
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }

}
