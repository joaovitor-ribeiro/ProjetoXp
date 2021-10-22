import { senhaDTO } from './../model/senhaDTO.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UsuarioDto } from '../model/usuarioDto.model';
import { take } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioFormService {

  private readonly XP = `${environment.XP}usuario`

  constructor(private http: HttpClient) {}

  public cadastroUsuario(usuario: UsuarioDto): Observable<boolean> {
    return this.http.post<boolean>(this.XP+'/cadastro', usuario);
  }

  public atualizarUsuario(nick: string, usuario: UsuarioDto){
    return this.http.put(this.XP+'/atualizar/' + nick, usuario).pipe(take(1));
  }

  public getUsuarioNick(nick: string): Observable<UsuarioDto> {
    return this.http.get<UsuarioDto>(this.XP+'/editar/' + nick);
  }

  public atualizarSenha(nick: string | null, senha: senhaDTO){
    return this.http.put(this.XP+'/alterarSenha/' + nick, senha).pipe(take(1));
  }
}
