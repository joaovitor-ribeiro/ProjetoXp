import { CampeonatoService } from './service/campeonato.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of, Subscription } from 'rxjs';
import { Campeonato } from './model/campeonato.model';

@Component({
  selector: 'app-campeonato',
  templateUrl: './campeonato.component.html',
  styleUrls: ['./campeonato.component.css']
})
export class CampeonatoComponent implements OnInit {

  campeonato$!: Observable<Campeonato[]>
  inscricao!: Subscription;

  constructor(private camopeonatoService: CampeonatoService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.inscricao = this.route.data.subscribe(
      (list) => {
        this.campeonato$ = of(list.campeonato);
      }
    );
  }

  ngOnDestroy(){
    this.inscricao.unsubscribe();
  }

}
