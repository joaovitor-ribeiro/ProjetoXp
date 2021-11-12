import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { interval, Observable, of, Subscription } from 'rxjs';
import { finalize, timeout } from 'rxjs/operators';
import { MatchDto } from '../guards/match/matchDto.model';
import { ProfileService } from './../profile.service';

@Component({
  selector: 'app-match',
  templateUrl: './match.component.html',
  styleUrls: ['./match.component.css']
})
export class MatchComponent implements OnInit {

  matchDto$ !: Observable<MatchDto[]>;
  matchDtoA: MatchDto[] = [];
  matchDtoB: MatchDto[] = [];
  inscricao!: Subscription;
  tempoDePartida !: string;
  venceu = false;
  displayedColumns: string[] = ['champion', 'nome', 'kda', 'cs', 'item'];
  isLoading = true;
  usuario !: string;

  constructor(
    private route: ActivatedRoute,
    private profileService: ProfileService,
  ) { }

  ngOnInit(){
    this.inscricao = this.route.params.subscribe(params =>{
      this.usuario = params['name'].trim();
      this.profileService.getMatch(params['name'], params['match']).subscribe(result => {
        this.matchDto$ = of(result);
        this.carregaDados(result);
        this.matchDto$.subscribe(result => {
          for (let i = 0; i < result.length; i++) {
            if(i < 5){
              this.matchDtoA.push(result[i]);
            }else{
              this.matchDtoB?.push(result[i]);
            }
          }
          setTimeout(() => {
            this.isLoading = false
          }, 2100);
        })
      })
    })
  }

  carregaDados(info: any) {
    this.tempoDePartida = info[0].gameDuration;
    info.forEach((result: MatchDto) => {
      if(result.summonerName.replace(' ','').toLowerCase() === this.usuario.toLowerCase()){
        this.venceu = result.win;
      }
    });
  }
}

