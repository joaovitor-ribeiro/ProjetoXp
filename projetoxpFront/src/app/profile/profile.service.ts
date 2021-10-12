import { Injectable } from '@angular/core';
import { MatchService } from './guards/match/match.service';
import { SummonerService } from './guards/summoner/summoner.service';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private summonerService: SummonerService, private matchService : MatchService) { }

  getSummoner(name : string){
    return this.summonerService.getSummonerByName(name);
  }

  getMatch(name: string, match: string){
    return this.matchService.getMatchByname(name,match);
  }

}
