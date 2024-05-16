import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoanApplication } from './loanApplication';

@Injectable({
  providedIn: 'root',
})
export class LoanProcessService {
  token: String = localStorage.getItem('lms_token') ?? '';

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: `Bearer ${this.token}`,
  });

  constructor(private http: HttpClient) {}

  applyLoan(loanApp: LoanApplication): Observable<LoanApplication> {
    return this.http.post<LoanApplication>(
      'http://localhost:8083/process/application',
      loanApp,
      {
        headers: this.headers,
      }
    );
  }

  viewLoanApplications(): Observable<LoanApplication[]> {
    return this.http.get<LoanApplication[]>(
      'http://localhost:8083/process/loanApplications',
      {
        headers: this.headers,
      }
    );
  }

  alterLoanStatus(loanObj:{applicationId:any, loanStatus:any}): Observable<LoanApplication[]> {
    console.log(loanObj," :::::: " , this.token);

    return this.http.put<LoanApplication[]>(
      'http://localhost:8083/process/loanApplication',loanObj ,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
  }
}
