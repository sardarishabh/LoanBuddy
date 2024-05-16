import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { GlobalComponent } from '../global/global.component';
import { LoginCreds } from './login';




@Injectable({
  providedIn: 'root',
})
export class LoginService implements OnInit {
  constructor(private http: HttpClient, private route: ActivatedRoute) {}

  ngOnInit(): void {}

  login(loginCreds: LoginCreds): Observable<any> {
    return this.http.post('http://localhost:8081/auth/login/', loginCreds, {
      responseType: 'text',
    });
  }

  validate(token: any) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
    return this.http.get('http://localhost:8081/auth/validate', {
      headers: headers,
      responseType: 'text',
    });
  }

}
