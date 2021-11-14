import { UsuarioDto } from './../model/usuarioDto.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly XP = `${environment.XP}usuario`
  private isLogin = false;

  constructor(
    private http: HttpClient,
    private router: Router,
  ) { }

  authenticate(nick: string, senha: string) {
    this.http.get(this.XP + '/login/' + nick + '/' + senha).subscribe(
      result => {
        if(this.getResult(result, nick)){
          this.router.navigate(['campeonato']);
        }
        this.isLogin = this.getResult(result, nick);
      }
    );
    return this.isLogin;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  getResult(result: any, nick: string) {
    if (result) {
      sessionStorage.setItem('username', result.nick)
      sessionStorage.setItem('file', result.file)
      return true;
    } else {
      return false;
    }
  }

  getSessionNick() {
    let user = sessionStorage.getItem('username')
    return user;
  }

  getSessionFile() {
    let file = sessionStorage.getItem('file')
    return file;
  }
}
