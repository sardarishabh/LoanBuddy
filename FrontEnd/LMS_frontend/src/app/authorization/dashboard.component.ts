import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Member } from '../member/member';
import { MemberService } from '../member/member.service';
import { DomSanitizer, SafeUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  member: Member = new Member();
  name: any;
  contact: any;
  email: any;

  constructor(
    private memberService: MemberService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    if (localStorage.getItem('ILI') === 'false') {
      this.router.navigate(['/login']);
      alert('you are not logged in...');
    }
    this.name = this.route.snapshot.params['userName'];
    // console.log(this.name);
    this.memberService.getMemberByUserName(this.name).subscribe((data) => {
      // console.log(data);

      this.member = data;
      localStorage.setItem('userName', data.userName);
      localStorage.setItem('memType', data.memberType);
      var memId: number = data.memberId;
      localStorage.setItem('Id', JSON.stringify(memId));
    });
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
