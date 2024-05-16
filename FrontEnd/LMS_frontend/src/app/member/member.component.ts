import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from './member';
import { MemberService } from './member.service';

@Component({
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css'],
})
export class MemberComponent implements OnInit {
  members: Member[] = [];
  mStatus: string = '';

  constructor(private memberService: MemberService, private router: Router) {}

  ngOnInit(): void {
    if (localStorage.getItem('ILI') === 'false') {
      this.router.navigate(['/login']);
      alert('you are not logged in...');
    }

    this.memberService.getMembers().subscribe((data: any) => {
      this.members = data;
    });
  }

  onLogout() {
    let token = localStorage.removeItem('lms_token');
    localStorage.clear();
    this.router.navigate(['/login']);
  }
}
