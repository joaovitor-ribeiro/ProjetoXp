import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { CampeonatoDto } from '../model/campeonatoDto.model';

@Injectable({
  providedIn: 'root'
})
export class CampeonatoFormService {

  private readonly XP = `${environment.XP}campeonato`

  constructor(private http: HttpClient) {}

  public cadastroCampeonato(campeonato: CampeonatoDto) {
    return this.http.post(this.XP+'/cadastro', campeonato).pipe(take(1));
  }

  public atualizarCampeonato(id: number, campeonato: CampeonatoDto) {
    return this.http.put(this.XP+'/atualizar/' + id, campeonato).pipe(take(1));
  }

  public retorncampeonato(id: number): Observable<CampeonatoDto> {
    return this.http.get<CampeonatoDto>(this.XP+'/retorna/' + id);
  }

}
