import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { CampeonatoService } from '../service/campeonato.service';
import { TimesParticipantes } from '../model/TimesParticipates.model';
import { TimeService } from 'src/app/time/service/time.service';
import { AuthenticationService } from 'src/app/usuario/service/authentication.service';

@Component({
  selector: 'app-campeonato-detalhes',
  templateUrl: './campeonato-detalhes.component.html',
  styleUrls: ['./campeonato-detalhes.component.scss']
})


export class CampeonatoDetalhesComponent  implements OnInit, OnDestroy {

  displayedColumns: string[] = ['id', 'name', 'capitao', 'edit'];

  timesParticipantes!: TimesParticipantes[]
  timesParticipantesA!: string;
  timesParticipantesB!: string;
  campeonatoDto: CampeonatoDto = new CampeonatoDto();
  inscricao!: Subscription;
  id!: number;
  quantidadeTime!: number;
  rodada!: number;
  tamanho!: number;
  index = 0;
  j = 0;
  cadastrarTime = false;
  myMap = new Map();
  edit = false;
  usuario!: any;
  editarTime = false;

  constructor(
    private timeService: TimeService,
    private route: ActivatedRoute,
    private router: Router,
    private loginService: AuthenticationService,
  ) { }

  ngOnInit(): void {
    this.usuario = this.loginService.getSessionNick();
    this.inscricao = this.route.data.subscribe(
      (campeonato) => {
        this.campeonatoDto = (campeonato.detalhes);
        this.edit = this.campeonatoDto.adm == this.usuario;
        this.route.params.subscribe(params =>{
          this.timeService.getTimesParticipantes(params['id']).subscribe(
            result => this.preencheTimesParticipantes(result)
          );
          this.id = params['id'];
        })
      }
    );
  }

  ngOnDestroy(): void {
    this.inscricao.unsubscribe();
  }

  preencheTimesParticipantes(result: TimesParticipantes[]): void {
    this.timesParticipantes = result;
    this.timesParticipantes.forEach(time => {
      if(!this.editarTime){
        this.editarTime = time.posicao == 1;
      }
    })
    this.tamanho = result.length;
    if(result.length == this.campeonatoDto.time){
      this.cadastrarTime = true;
    }
    if(this.tamanho % 2 == 0 || this.tamanho == 1){
      this.quantidadeTime = this.tamanho;
    }else{
      this.quantidadeTime = this.tamanho + 1;
    }
  }

  meio(){
    let contador = 0;
    let times = this.quantidadeTime;
    for (let i = 0; i < this.quantidadeTime; i++) {
      if(times > 1){
        contador++;
      }
      times = times / 2;
    }
    return new Array(contador);
  }

  condicaoLi(index: number){
    if(index == 0){
      this.rodada = this.quantidadeTime / 2;
    }else if(this.rodada > 1){
      if(!(this.rodada % 2 == 0)){
        this.rodada++;
      }
      this.rodada = this.rodada / 2;
    }
    return new Array(this.rodada);
  }

  classe(){
    if(this.rodada == this.quantidadeTime / 2){
      return "first"
    }else if(this.rodada == 1){
      return "final"
    }else if(this.rodada <= 1){
      return "winner"
    }
    return "team-item"
  }

  timaA(i: number, j: number,  timeA: string){
    if(i != this.j ){
      this.index = 0;
      this.j = i;
    }
    while(this.index < this.timesParticipantes.length){
      if(this.timesParticipantes[this.index].posicao <= (this.rodada * 2)){
          this.index++;
        if(timeA == 'a'){
          this.timesParticipantesA = this.timesParticipantes[this.index-1].nomeTime;
        }else{
          this.timesParticipantesB = this.timesParticipantes[this.index-1].nomeTime;
        }
        this.myMap.set(i+""+j+""+timeA, this.timesParticipantes[this.index-1].nomeTime);
        return this.timesParticipantes[this.index-1].nomeTime;
      }
      this.index++;
    }
    if(timeA == 'a'){
      this.timesParticipantesA = 'TBD';
    }else{
      this.timesParticipantesB = 'TBD';
    }
    return 'TBD';
  }

  ganhouNome(a: any, b: any, c: any){
    for (let i = 0; i < this.timesParticipantes.length; i++) {
      if (this.timesParticipantes[i].nomeTime == this.myMap.get(a + ""+ b + "" + ""+ c)) {
        this.ganhou(this.timesParticipantes[i].timeCapitao);
      }
    }
  }

  ganhou(idTime: any){
    this.timeService.atualizarPosicao(this.id, idTime).subscribe(
      sucess => window.location.reload(),
      error => console.log('error'),
      () => console.log('request completo')
    );
  }

  disableNome(nome: any, quantidade: any){
    for (let i = 0; i < this.timesParticipantes.length; i++) {
      if (this.timesParticipantes[i].nomeTime == nome) {
        if (this.timesParticipantes[i].posicao < (this.rodada * 2)) {
          return true;
        }
      }
    }
    return false;
  }

  vencedor(){
    for (let i = 0; i < this.timesParticipantes.length; i++) {
      if(this.timesParticipantes[i].posicao == 1){
        return this.timesParticipantes[i].nomeTime;
      }
    }
    return 'TBD';
  }

  formataData(dataFormata: any){
    let data: String[] = dataFormata.split('-');

    dataFormata = data[2] + "/" + data[1] + "/" + data[0];

    return dataFormata;
  }

  premiacao(premiacao: any){
    premiacao = premiacao + '';
    return  premiacao.replace(/^(\d{1})?(\d{3})?(\d{3})?(\d{2})/, 'R$ $1.$2.$3,$4');
  }

  cadastroTime(){
    this.router.navigate([`/time/${this.id}/cadastro`]);
  }

}
