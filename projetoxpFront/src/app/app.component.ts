import { Component } from '@angular/core';
import {MatMenuModule} from '@angular/material/menu';
import { AuthenticationService } from './usuario/service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projetoxpFront';

  constructor(public loginService: AuthenticationService){}
}
