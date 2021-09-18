import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { CampeonatoService } from '../service/campeonato.service';
import { BaseFormComponent } from '../../shared/base-form/base-form.component';
import { Time } from '../../time/model/time.model';
import { TimesParticipantes } from '../model/TimesParticipates.model';

@Component({
  selector: 'app-campeonato-detalhes',
  templateUrl: './campeonato-detalhes.component.html',
  styleUrls: ['./campeonato-detalhes.component.scss']
})

export class CampeonatoDetalhesComponent  implements OnInit, OnDestroy {

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
  myMap = new Map();

  constructor(
    private campeonatoService: CampeonatoService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.inscricao = this.route.data.subscribe(
      (campeonato) => {
        this.campeonatoDto = (campeonato.detalhes);
        this.route.params.subscribe(params =>{
          this.campeonatoService.getTimesParticipantes(params['id']).subscribe(
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
    this.tamanho = result.length;
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
      // times = times / 2;
      if(times > 1){
        contador++;
      }
      times = times / 2;
    }
    console.log('contador');
    console.log(contador);
    return new Array(contador);
  }

  condicaoLi(index: number){
    if(index == 0){
      this.rodada = this.quantidadeTime / 2;
    }else if(this.rodada > 1){
      this.rodada = this.rodada / 2;
    }
    console.log('index');
    console.log(index);
    console.log(this.rodada);
    return new Array(this.rodada);
  }

  classe(){
    if(this.rodada == this.quantidadeTime / 2){
      return "first"
    }else if(this.rodada == 1){
      return "final"
    }else if(this.rodada <= 1){
      console.log(this.rodada)
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
        this.ganhou(this.timesParticipantes[i].idTime);
      }
    }
  }

  ganhou(idTime: any){
    this.campeonatoService.atualizarPosicao(idTime).subscribe(
      sucess => console.log('sucesso'),
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

}
