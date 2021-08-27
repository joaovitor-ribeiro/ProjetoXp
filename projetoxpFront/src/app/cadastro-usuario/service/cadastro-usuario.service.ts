import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { UsuarioDto } from '../model/usuarioDto.model';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CadastroUsuarioService {

  private readonly XP = `${environment.XP}cadastro`

  constructor(private http: HttpClient) {}

  public cadastroUsuario(usuario: UsuarioDto) {
    return this.http.post(this.XP, usuario).pipe(take(1));
  }

}
