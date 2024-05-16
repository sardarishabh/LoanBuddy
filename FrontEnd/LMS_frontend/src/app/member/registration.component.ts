import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Member } from './member';
import { MemberService } from './member.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent {
  regForm!: FormGroup;
  Roles: any = ['A', 'U'];
  Genders: any = ['M', 'F', 'O'];
  memberId!: number;
  firstName!: string;
  lastName!: string;
  address!: string;
  contactNumber!: string;
  emailId!: string;
  gender!: string;
  civilStatus!: number;
  dateOfBirth!: string;
  age!: number;
  userName!: string;
  password!: string;
  memberType!: string;
  memAge!: any;

  constructor(
    private router: Router,
    private memberservice: MemberService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    var today: any = new Date();
    var dd: any = today.getDate();
    var mm: any = today.getMonth() + 1; //January is 0!
    var yyyy: any = today.getFullYear();

    if (dd < 10) {
      dd = '0' + dd;
    }

    if (mm < 10) {
      mm = '0' + mm;
    }

    today = yyyy + '-' + mm + '-' + dd;
    localStorage.setItem('today', today);
    document.getElementById('dob')?.setAttribute('max', today);
  }

  submitDOB() {
    var dob = (<HTMLInputElement>document.getElementById('dob')).value;
    var Bdate = +new Date(dob);
    this.memAge = (Date.now() - Bdate) / 31557600000;
    this.memAge = Math.floor(this.memAge);
    console.log(this.memAge);
    localStorage.setItem('memAge', this.memAge);
  }

  onRegister(member: Member) {
    this.memberservice.addMember(member).subscribe((data) => {
      console.log(data);
    });
    alert('Registration successful, redirecting to Login page..');
    this.router.navigate(['/login']);
  }

  onCancel() {
    this.router.navigate(['/login']);
  }
}
