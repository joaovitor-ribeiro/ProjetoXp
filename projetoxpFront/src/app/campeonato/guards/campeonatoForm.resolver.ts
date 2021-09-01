import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { CampeonatoFormService } from '../service/campeonato-form.service';

@Injectable()
export class CampeonatoFormResolver implements Resolve<CampeonatoDto> {

    constructor(private campeonatoFormService: CampeonatoFormService){}

    resolve(route: ActivatedRouteSnapshot): Observable<CampeonatoDto>{
        let id = route.params['id'];
        return this.campeonatoFormService.getCampeonatoId(id);
    }
}
