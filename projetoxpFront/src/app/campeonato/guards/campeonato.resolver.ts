import { CampeonatoService } from './../service/campeonato.service';
import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Campeonato } from '../model/campeonato.model';

@Injectable()
export class CampeonatoResolver implements Resolve<Campeonato[]> {

    constructor(private campeonatoService: CampeonatoService){}

    resolve(route: ActivatedRouteSnapshot):  Observable<Campeonato[]>{
        return this.campeonatoService.listarCampeonato();
    }
}
