import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { TimeService } from './../service/time.service';
import { Time } from './../model/time.model';

@Component({
  selector: 'app-time-detalhes',
  templateUrl: './time-detalhes.component.html',
  styleUrls: ['./time-detalhes.component.css']
})
export class TimeDetalhesComponent implements OnInit {
  displayedColumns: string[] = ['name'];
  time!: Time;
  jogadores: string[] = [];
  constructor(
    private route: ActivatedRoute,
    private timeService: TimeService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(result => {
      this.timeService.getTimeDetalhes(Number(result.id)).subscribe(time => {
        this.time = time;
        this.alimentaJogadores();
      })
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
