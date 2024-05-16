import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from './member';
import { LoanService } from '../loan/loan.service';

@Injectable({
  providedIn: 'root',
})
export class MemberService {
  token: String = localStorage.getItem('lms_token') ?? '';
  memberId!: number;
  firstName!: string;
  lastName!: string;
  address!: string;
  contact!: String;
  email!: String;
  gender!: string;
  civilStatus!: number;
  dateOfBirth!: string;
  age!: number;
  userName!: string;
  password!: string;

  headers = new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: `Bearer ${this.token}`,
  });

  constructor(private http: HttpClient, private loanService: LoanService) {}

  getMembers(): Observable<Member[]> {
    return this.http.get<Member[]>('http://localhost:8084/member/members', {
      headers: this.headers
    });
  }


  getMemberById(id: number): Observable<Member> {
    return this.http.get<Member>('http://localhost:8084/member/member/' + id, {
      headers: this.headers,
      responseType: 'json'
    });
  }

  getMemberByUserName(name: any): Observable<Member> {
    return this.http.get<Member>(`http://localhost:8084/member/memberName/${name}`, {
      headers: this.headers,
      responseType: 'json',
    });
  }

  addMember(member: Member): Observable<Member> {
    return this.http.post<Member>(
      'http://localhost:8084/member/member',
      member
    );
  }

  memberType(id: number): Observable<Member> {
    return this.http.get<Member>(
      'http://localhost:8084/member/memberType/' + id,
      {
        headers: this.headers,
        responseType: 'json',
      }
    );
  }
}
