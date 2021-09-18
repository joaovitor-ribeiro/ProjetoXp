import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UsuarioDto } from '../model/usuarioDto.model';
import { UsuarioFormService } from '../service/cadastro-usuario.service';


@Injectable()
export class UsuarioFormResolver implements Resolve<UsuarioDto> {

    constructor(private campeonatoFormService: UsuarioFormService){}

    resolve(route: ActivatedRouteSnapshot): Observable<UsuarioDto>{
        let id = route.params['id'];
        return this.campeonatoFormService.getUsuarioId(id);
    }
}
