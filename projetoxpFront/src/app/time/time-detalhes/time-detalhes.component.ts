import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { TimeService } from './../service/time.service';
import { Time } from './../model/time.model';
import { Observable, of } from 'rxjs';
import { Campeonato } from 'src/app/campeonato/model/campeonato.model';
import { AuthenticationService } from 'src/app/usuario/service/authentication.service';
import { CampeonatoService } from 'src/app/campeonato/service/campeonato.service';

@Component({
  selector: 'app-time-detalhes',
  templateUrl: './time-detalhes.component.html',
  styleUrls: ['./time-detalhes.component.css']
})
export class TimeDetalhesComponent implements OnInit {
  displayedColumns: string[] = ['name'];
  time!: Time;
  campeonato$!: Observable<Campeonato[]>
  jogadores: string[] = [];
  usuario!: any;

  constructor(
    private route: ActivatedRoute,
    private timeService: TimeService,
    private loginService: AuthenticationService,
    private camopeonatoService: CampeonatoService,
  ) { }

  ngOnInit(): void {
    debugger
    this.usuario = this.loginService.getSessionNick();
    this.route.params.subscribe(result => {
      this.timeService.getTimeDetalhes(Number(result.id)).subscribe(time => {
        this.time = time;
        this.alimentaJogadores();
      });
      this.camopeonatoService.getCampeonatoByIdTime(Number(result.id)).subscribe(campeonatos => {
        console.log(campeonatos);
        this.campeonato$ = of(campeonatos);
      });
    });
  }
  alimentaJogadores(){
    this.jogadores.push(this.time.capitao);
    this.jogadores.push(this.time.jogador2);
    this.jogadores.push(this.time.jogador3);
    this.jogadores.push(this.time.jogador4);
    this.jogadores.push(this.time.jogador5);
  }


}
