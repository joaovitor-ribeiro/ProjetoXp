import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CampeonatoDto } from '../model/campeonatoDto.model';

@Injectable({
  providedIn: 'root'
})
export class CadastroCampeonatoService {

  private readonly XP = `${environment.XP}cadastro`

  constructor(private http: HttpClient) {}

  public cadastroCampeonato(campeonato: CampeonatoDto) {
    return this.http.post(this.XP+'/campeonato', campeonato).pipe(take(1));
  }

}
