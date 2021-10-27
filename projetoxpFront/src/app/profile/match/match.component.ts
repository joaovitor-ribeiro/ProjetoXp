import { ProfileService } from './../profile.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of, Subscription } from 'rxjs';
import { MatchDto } from '../guards/match/matchDto.model';

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
  venceu !: string;
  displayedColumns: string[] = ['champion', 'nome', 'kda', 'cs', 'item'];
  isLoading = true;

  constructor(
    private route: ActivatedRoute,
    private profileService: ProfileService,
  ) { }

  ngOnInit(){
    this.inscricao = this.route.params.subscribe(params =>{
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
            this.isLoading = false;
          }
        })
      })
    })
  }

  carregaDados(info: any) {
    this.tempoDePartida = info[0].gameDuration;
    this.venceu = info[0].venceu;
  }
}

