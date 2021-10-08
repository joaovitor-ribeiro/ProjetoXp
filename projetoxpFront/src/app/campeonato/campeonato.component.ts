import { CampeonatoService } from './service/campeonato.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of, Subscription } from 'rxjs';
import { Campeonato } from './model/campeonato.model';
import { AuthenticationService } from '../usuario/service/authentication.service';

@Component({
  selector: 'app-campeonato',
  templateUrl: './campeonato.component.html',
  styleUrls: ['./campeonato.component.css']
})
export class CampeonatoComponent implements OnInit {

  campeonato$!: Observable<Campeonato[]>
  inscricao!: Subscription;
  id!: string
  usuario!: any;

  constructor(
    private camopeonatoService: CampeonatoService,
    private route: ActivatedRoute,
    private router: Router,
    private login: AuthenticationService,
  ) { }

  ngOnInit(): void {
    this.inscricao = this.route.data.subscribe(
      (list) => {
        this.campeonato$ = of(list.campeonato);
        this.id = list.campeonato.id;
        this.usuario = this.login.getSessionItem();
      }
    );
  }

  ngOnDestroy(){
    this.inscricao.unsubscribe();
  }

}
