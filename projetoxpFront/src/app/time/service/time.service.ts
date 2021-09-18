import { Time } from "@angular/common";
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { take } from "rxjs/operators";
import { environment } from "src/environments/environment";

@Injectable({
  providedIn: 'root'
})

export class CampeonatoService {

  private readonly XP = `${environment.XP}time`

  constructor(private http: HttpClient) {}

  public cadastrarTime(time: Time){
    return this.http.post(this.XP + '/cadastro', time).pipe(take(1));
  }

}
