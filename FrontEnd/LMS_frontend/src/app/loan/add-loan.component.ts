import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Loan } from './loan';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css'],
})
export class AddLoanComponent implements OnInit {

  memType = localStorage.getItem('memType');
  constructor(
    private LoanService: LoanService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {}

  onSubmit(loan: Loan) {
    this.LoanService.addLoan(loan).subscribe((data) => {
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
