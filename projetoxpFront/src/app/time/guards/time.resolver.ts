import { Injectable } from "@angular/core";
import { Resolve, ActivatedRouteSnapshot } from "@angular/router";
import { Observable } from "rxjs";
import { Time } from "../model/time.model";
import { TimeService } from "../service/time.service";


@Injectable()
export class TimeResolver implements Resolve<Time[]> {

    constructor(private timeService: TimeService){}

    resolve(route: ActivatedRouteSnapshot):  Observable<Time[]>{
        return this.timeService.listarTimeByUsuario(route.params.nick);
    }
}
