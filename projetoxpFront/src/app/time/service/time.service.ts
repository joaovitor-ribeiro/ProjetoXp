import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { take } from "rxjs/operators";
import { TimesParticipantes } from "src/app/campeonato/model/TimesParticipates.model";
import { environment } from "src/environments/environment";
import { Time } from "../model/time.model";

@Injectable({
  providedIn: 'root'
})

export class TimeService {

  private readonly XP = `${environment.XP}time`

  constructor(private http: HttpClient) {}

  public cadastrarTime(id: number, timeDto: Time){
    return this.http.post(this.XP + `/cadastro/${id}`, timeDto).pipe(take(1));
  }

  public getTimesParticipantes(id:any): Observable<TimesParticipantes[]> {
    return this.http.get<TimesParticipantes[]>(this.XP+'/participantes/' + id);
  }

  atualizarPosicao(id:any, idTime: any) {
    return this.http.put(this.XP+'/atualizar/posicao/' + id, idTime).pipe(take(1));
  }

  public getTimes(): Observable<Time[]> {
    return this.http.get<Time[]>(this.XP+'/listar');
  }

}
