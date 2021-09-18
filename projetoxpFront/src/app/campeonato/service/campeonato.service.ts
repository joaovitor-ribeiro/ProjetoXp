import { TimesParticipantes } from './../model/TimesParticipates.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Campeonato } from '../model/campeonato.model';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CampeonatoService {

  private readonly XP = `${environment.XP}campeonato`

  constructor(private http: HttpClient) {}

  public listarCampeonato(): Observable<Campeonato[]> {
    return this.http.get<Campeonato[]>(this.XP + '/listar');
  }

  public getCampeonatoId(id: number): Observable<CampeonatoDto> {
    return this.http.get<CampeonatoDto>(this.XP+'/editar/' + id);
  }

  public getTimesParticipantes(id:any): Observable<TimesParticipantes[]> {
    return this.http.get<TimesParticipantes[]>(this.XP+'/participantes/' + id);
  }

  atualizarPosicao(idTime: any) {
    return this.http.put(this.XP+'/atualizar/posicao', idTime).pipe(take(1));
  }

}
