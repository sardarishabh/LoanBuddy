import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoanComponent } from './loan/loan.component';
import { LoanProcessComponent } from './loan-process/loan-process.component';

import { RegistrationComponent } from './member/registration.component';
import { LoginComponent } from './authorization/login.component';
import { AddLoanComponent } from './loan/add-loan.component';
import { DeleteLoanComponent } from './loan/delete-loan.component';
import { UpdateLoanComponent } from './loan/update-loan.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MemberComponent } from './member/member.component';
import { GlobalComponent } from './global/global.component';
import { AddMemberComponent } from './member/add-member.component';
import { DashboardComponent } from './authorization/dashboard.component';
import { LoanApplicationComponent } from './loan-process/loan-application.component';
import { ViewLoansComponent } from './loan-process/view-loans.component';


@NgModule({
  declarations: [
    AppComponent,
    LoanComponent,
    AddLoanComponent,
    LoanProcessComponent,
    MemberComponent,
    LoginComponent,
    RegistrationComponent,
    DeleteLoanComponent,
    UpdateLoanComponent,
    GlobalComponent,
    AddMemberComponent,
    DashboardComponent,
    LoanApplicationComponent,
    ViewLoansComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FlexLayoutModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
