import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CampeonatoDto } from '../model/campeonatoDto.model';

@Injectable({
  providedIn: 'root'
})
export class CampeonatoFormService {

  private readonly XP = `${environment.XP}campeonato`

  constructor(private http: HttpClient) {}

  public cadastroCampeonato(campeonato: CampeonatoDto): Observable<number> {
    return this.http.post<number>(this.XP+'/cadastro', campeonato);
  }

  public atualizarCampeonato(id: number, campeonato: CampeonatoDto): Observable<number> {
    return this.http.put<number>(this.XP+'/atualizar/' + id, campeonato);
  }

  public retorncampeonato(id: number): Observable<CampeonatoDto> {
    return this.http.get<CampeonatoDto>(this.XP+'/retorna/' + id);
  }

}
