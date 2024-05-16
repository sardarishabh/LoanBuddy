import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loan } from './loan';
import { LoanService } from './loan.service';

@Component({
  selector: 'app-delete-loan',
  templateUrl: './delete-loan.component.html',
  styleUrls: ['./delete-loan.component.css'],
})
export class DeleteLoanComponent {
  loan!: Loan;
  id:any;
  memType = localStorage.getItem('memType');
  constructor(
    private loanService: LoanService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['loanId'];
    this.loanService.getLoanById(this.id).subscribe((data) => {
      this.loan = data;
    });
  }

  onDelete() {
    this.loanService.deleteLoan(this.id).subscribe(data => {
      console.log(data);

    })
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
