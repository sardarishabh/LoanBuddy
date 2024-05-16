import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './authorization/dashboard.component';
import { LoginComponent } from './authorization/login.component';
import { LoanApplicationComponent } from './loan-process/loan-application.component';
import { ViewLoansComponent } from './loan-process/view-loans.component';
import { AddLoanComponent } from './loan/add-loan.component';
import { DeleteLoanComponent } from './loan/delete-loan.component';
import { LoanComponent } from './loan/loan.component';
import { UpdateLoanComponent } from './loan/update-loan.component';
import { MemberComponent } from './member/member.component';
import { RegistrationComponent } from './member/registration.component';

const routes: Routes = [
  { path: 'loans', component: LoanComponent },
  { path: 'add', component: AddLoanComponent },
  { path: 'delete/:loanId', component: DeleteLoanComponent },
  { path: 'update/:loanId', component: UpdateLoanComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegistrationComponent},
  { path: 'dashboard/:userName', component: DashboardComponent},
  { path: 'loan-application', component: LoanApplicationComponent},
  { path: 'memberlist', component: MemberComponent},
  { path: 'applications', component: ViewLoansComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'dashboard', redirectTo: 'dashboard/'+ localStorage.getItem('userName'), pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
