import { UsuarioDto } from './../model/usuarioDto.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private readonly XP = `${environment.XP}usuario`
  private isLogin = false;

  constructor(private http: HttpClient) { }

  authenticate(nick: string, senha: string) {
    this.http.get(this.XP + '/login/' + nick + '/' + senha).subscribe(
      result => this.isLogin = this.getResult(result, nick)
    );
    return this.isLogin;
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  getResult(result: any, nick: string) {
    if (result) {
      sessionStorage.setItem('username', nick)
      return true;
    } else {
      return false;
    }
  }

  getSessionItem() {
    let user = sessionStorage.getItem('username')
    return sessionStorage.getItem('username');
  }

}
