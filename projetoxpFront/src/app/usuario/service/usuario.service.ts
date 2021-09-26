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

  public cadastroUsuario(usuario: UsuarioDto) {
    return this.http.post(this.XP+'/cadastro', usuario).pipe(take(1));
  }

  public atualizarUsuario(id: number, usuario: UsuarioDto) {
    return this.http.put(this.XP+'/atualizar/' + id, usuario).pipe(take(1));
  }

  public getUsuarioNick(nick: string): Observable<UsuarioDto> {
    return this.http.get<UsuarioDto>(this.XP+'/editar/' + nick);
  }
}
