import { Time } from './model/time.model';
import { Component, OnInit } from '@angular/core';
import { Subscription, Observable, of } from 'rxjs';
import { TimeService } from './service/time.service';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../usuario/service/authentication.service';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  time$!: Observable<Time[]>
  inscricao!: Subscription;
  id!: string
  nick!: any;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    public login: AuthenticationService,
  ) { }

  ngOnInit(): void {
    this.inscricao = this.route.data.subscribe(
      (list) => {
        this.time$ = of(list.time);
        this.id = list.time.id;
        this.nick = this.login.getSessionNick();
      }
    );
  }

  ngOnDestroy(){
    this.inscricao.unsubscribe();
  }

}
