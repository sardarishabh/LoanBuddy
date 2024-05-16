import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginCreds } from './login';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  form!: FormGroup;
  userName: any;
  password: any;
  loginCred: LoginCreds = new LoginCreds();
  isLoggedIn: string = 'false';

  constructor(
    private fb: FormBuilder,
    private loginService: LoginService,
    private router: Router,
    private http: HttpClient
  ) {
    this.form = this.fb.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    localStorage.setItem('ILI', this.isLoggedIn);

  }
  onLogin(loginCreds: LoginCreds) {
    this.loginCred = loginCreds;
    this.loginService.login(loginCreds).subscribe((data) => {
      // console.log(data);
      this.loginService.validate(data).subscribe((status) => {
        console.log('validate:::::::' + status);
        localStorage.setItem('lms_token', data);
        this.isLoggedIn = 'true';
        localStorage.setItem('ILI', this.isLoggedIn);
        this.router.navigate(['/dashboard/' + this.loginCred.userName]);
      });
    });
  }
}
