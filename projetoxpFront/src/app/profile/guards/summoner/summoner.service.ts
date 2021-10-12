import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SummonerDto } from './summonerDto.model';
import { environment } from 'src/environments/environment';


@Injectable()
export class SummonerService {

  private readonly XP = `${environment.XP}profile/`

  constructor(private http: HttpClient) {}

  public getSummonerByName(name: string): Observable<SummonerDto[]> {
    return this.http.get<SummonerDto[]>(this.XP + name);
  }

}
