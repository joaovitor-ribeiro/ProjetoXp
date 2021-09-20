import { TimeService } from 'src/app/time/service/time.service';
import { Component, OnInit } from '@angular/core';
import { Time } from '../model/time.model';

@Component({
  selector: 'app-time-ranking',
  templateUrl: './time-ranking.component.html',
  styleUrls: ['./time-ranking.component.css']
})

export class TimeRankingComponent implements OnInit {

  displayedColumns: string[] = ['file', 'nome', 'pontuacao'];
  times!: Time[];

  constructor(
    private timeService: TimeService
  ) { }

  ngOnInit(): void {
    this.timeService.getTimes().subscribe( result =>{
     this.times = result;
     this.somaPontuacao();
     this.times.sort((a, b) => (a.pontuacao > b.pontuacao) ? -1 : 1);
    });
  }

  somaPontuacao(){
    for (let i = 0; i < this.times.length; i++) {
      for (let j = i + 1; j < this.times.length; j++) {
        if(this.times[i].timeCapitao == this.times[j].timeCapitao){
          this.times[i].pontuacao = this.times[i].pontuacao + this.times[j].pontuacao;
          let index = this.times.indexOf(this.times[j]);
          this.times.splice(index,1);
        }
      }
    }
  }

}

