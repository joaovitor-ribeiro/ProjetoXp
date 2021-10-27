import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { UsuarioDto } from '../model/usuarioDto.model';
import { UsuarioFormService } from '../service/usuario.service';


@Injectable()
export class UsuarioFormResolver implements Resolve<UsuarioDto> {

    constructor(private campeonatoFormService: UsuarioFormService){}

    resolve(route: ActivatedRouteSnapshot): Observable<UsuarioDto>{
        let nick = route.params['nick'];
        return this.campeonatoFormService.getUsuarioNick(nick);
    }
}
