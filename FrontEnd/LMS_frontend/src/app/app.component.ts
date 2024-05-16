import { Component } from '@angular/core';
import { GlobalComponent } from './global/global.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LMS';
  auth_token = GlobalComponent.auth_token;
}
