import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { ProfileService } from './../profile.service';
import { MatchDto } from './match/matchDto.model';

@Injectable()
export class MatchResolver implements Resolve<MatchDto[]> {

    constructor(private profileService: ProfileService){}

    resolve(route: ActivatedRouteSnapshot):  Observable<MatchDto[]>{
        return this.profileService.getMatch(route.params['name'], route.params['match']);
    }
}
