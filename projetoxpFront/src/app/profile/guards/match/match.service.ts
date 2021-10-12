import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MatchDto } from './matchDto.model';
import { environment } from 'src/environments/environment';


@Injectable()
export class MatchService {

  private readonly XP = `${environment.XP}profile/`

  constructor(private http: HttpClient) {}

  public getMatchByname(name: string, match: string): Observable<MatchDto[]> {
    return this.http.get<MatchDto[]>(this.XP + name + '/match/' + match);
  }

}
