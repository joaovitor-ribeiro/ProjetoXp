import { TimesParticipantes } from './../model/TimesParticipates.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Campeonato } from '../model/campeonato.model';
import { CampeonatoDto } from '../model/campeonatoDto.model';

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
    return this.http.get<CampeonatoDto>(this.XP+'/retorna/' + id);
  }

  getCampeonatoByIdTime(id: number): Observable<Campeonato[]> {
    return this.http.get<Campeonato[]>(this.XP + `/time/${id}`);
  }

}
