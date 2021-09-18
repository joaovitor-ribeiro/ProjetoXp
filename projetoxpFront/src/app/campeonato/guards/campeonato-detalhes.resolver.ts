import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { CampeonatoService } from '../service/campeonato.service';

@Injectable()
export class CampeonatoDetalhesResolver implements Resolve<CampeonatoDto> {

    constructor(private campeonatoService: CampeonatoService){}

    resolve(route: ActivatedRouteSnapshot): Observable<CampeonatoDto>{
        let id = route.params['id'];
        return this.campeonatoService.getCampeonatoId(id);
    }
}
