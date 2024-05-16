import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loan } from './loan';

@Injectable({
  providedIn: 'root',
})
export class LoanService {
  token: String = localStorage.getItem('lms_token') ?? '';

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: `Bearer ${this.token}`,
  });

  constructor(private http: HttpClient) {}

  getLoans(): Observable<Loan[]> {
    return this.http.get<Loan[]>('http://localhost:8082/loan/loans', {
      headers: this.headers,
    });
  }

  addLoan(loan: Loan): Observable<Loan> {
    return this.http.post<Loan>('http://localhost:8082/loan/loan', loan, {
      headers: this.headers,
    });
  }

  getLoanById(id: number): Observable<Loan> {
    return this.http.get<Loan>('http://localhost:8082/loan/loan/' + id, {
      headers: this.headers,
      responseType: 'json',
    });
  }

  updateLoan(id: any, loan: Loan): Observable<any> {
    return this.http.put('http://localhost:8082/loan/loan/' + id, loan, {
      headers: this.headers,
      responseType: 'json',
    });
  }

  deleteLoan(id: number): Observable<Loan> {
    return this.http.delete<Loan>('http://localhost:8082/loan/loan/'+ id, {
      headers: this.headers,
    });
  }
}
