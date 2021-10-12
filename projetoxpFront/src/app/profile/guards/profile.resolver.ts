import { ProfileService } from './../profile.service';
import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { SummonerDto } from './summoner/summonerDto.model';

@Injectable()
export class ProfileResolver implements Resolve<SummonerDto[] | boolean> {

    constructor(private profileService: ProfileService){}

    resolve(route: ActivatedRouteSnapshot): Observable<SummonerDto[]> | boolean{
      if(route.params['name']){
        return this.profileService.getSummoner(route.params['name']);
      }
      return false;
    }
}
