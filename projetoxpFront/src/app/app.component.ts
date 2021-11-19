import { AfterContentChecked, Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './usuario/service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterContentChecked{
  title = 'projetoxpFront';
  usuario: any = '';
  foto: any = '';
  constructor(public loginService: AuthenticationService, private route: ActivatedRoute){

  }
  ngAfterContentChecked(): void {
    this.usuario = sessionStorage.getItem('username');
    this.foto = sessionStorage.getItem('file');
  }

}
