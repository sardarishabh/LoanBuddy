import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Loan } from './loan';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css'],
})
export class LoanComponent implements OnInit {
  loans: Loan[] = [];
  memType = localStorage.getItem('memType');

  constructor(private loanService: LoanService, private router: Router) {}

  ngOnInit(): void {
    if (localStorage.getItem('ILI') === 'false') {
      this.router.navigate(['/login']);
      alert('you are not logged in...');
    }
    this.loanService.getLoans().subscribe((data: any) => (this.loans = data));
  }

  onClick() {
    this.router.navigate(['/add']);
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
