import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { take } from 'rxjs/operators';
import { AuthenticationService } from './usuario/service/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projetoxpFront';
  usuario: any = '';
  constructor(public loginService: AuthenticationService, private route: ActivatedRoute){
    this.route.url.pipe(take(1)).subscribe( result => {
      if(loginService.getSessionNick()){
        this.usuario = loginService.getSessionNick();
      }
    });

  }

}
