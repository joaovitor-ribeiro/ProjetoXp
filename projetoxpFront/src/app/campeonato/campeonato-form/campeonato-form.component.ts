import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription, Observable, of } from 'rxjs';
import { BaseFormComponent } from '../../shared/base-form/base-form.component';
import { CampeonatoDto } from '../model/campeonatoDto.model';
import { CampeonatoFormService } from '../service/campeonato-form.service';
import { UploadFileService } from '../service/upload-file.service';

@Component({
  selector: 'app-cadastro-campeonato',
  templateUrl: './campeonato-form.component.html',
  styleUrls: ['./campeonato-form.component.css']
})
export class CampeonatoFormComponent extends BaseFormComponent implements OnInit {

  files: File | undefined;
  nameFile: string = '';
  campeonatoDto: CampeonatoDto = new CampeonatoDto();
  inscricao!: Subscription;
  editar: boolean = false;
  id!: number;
  select = 'time';

  selectOptions = [
    {nome: 4,  value:4},
    {nome: 8,  value:8},
    {nome: 16, value:16},
    {nome: 32, value:32},
    {nome: 64, value:64},
  ];

  constructor(
    private formBuilder: FormBuilder,
    private campeonatoFormService: CampeonatoFormService,
    private service: UploadFileService,
    private route: ActivatedRoute,
    private router: Router,
    ) {
      super();
    }

    ngOnInit(): void {
      this.formulario = this.formBuilder.group({
        'nome': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
        'dataInicio': [null, [Validators.required]],
        'dataTermino': [null, [Validators.required]],
        'time': [this.selectOptions[0], [Validators.required]],
        'premiacao': [null, [Validators.required]],
        'adm': [null, [Validators.required]],
        'descricao': [null, [Validators.required]],
        'regra': [null, [Validators.required]],
        'file': [null, []],
      });
    this.inscricao = this.route.data.subscribe(
      (campeonato) => {
        console.log(campeonato);
        if(campeonato.form != undefined){
          this.campeonatoDto = (campeonato.form);
          this.populaDadosForm(campeonato.form);
          this.route.params.subscribe(params =>{
            this.editar = true;
            this.id = params['id'];
          })
        }
      }
    );

  }

  populaDadosForm(campeonato: CampeonatoDto) {
    this.formulario.patchValue({
      nome: campeonato.nome,
      dataInicio: campeonato.dataInicio,
      dataTermino: campeonato.dataTermino,
      time: campeonato.time,
      premiacao: campeonato.premiacao,
      adm: campeonato.adm,
      descricao: campeonato.descricao,
      regra: campeonato.regra,
      file: campeonato.file
    });
    this.nameFile = campeonato.file;
  }

  onChange(event: any) {
    this.nameFile = event.srcElement.files[0].name;
    this.files = event.srcElement.files[0];
  }

  onUpload() {
    if (this.files && this.files.size > 0) {
      this.service.upload(this.files, 'campeonato');
    }
  }

  submit() {
    this.preenchendoCampeonatoDto();
    if(this.editar){
      if(this.nameFile != this.formulario.get('file')?.value){
        this.onUpload();
      }
      this.campeonatoFormService.atualizarCampeonato(this.id, this.campeonatoDto).subscribe(
        sucess =>  this.router.navigate(['campeonato']),
        error => console.log('error'),
        () => console.log('request completo')
      );
    }else{
      if(this.nameFile != ''){
        this.onUpload();
      }
      this.campeonatoFormService.cadastroCampeonato(this.campeonatoDto).subscribe(
        sucess => this.router.navigate(['campeonato']),
        error => console.log('error'),
        () => console.log('request completo')
      );
    }
  }

  preenchendoCampeonatoDto() {
    this.campeonatoDto.nome = this.formulario.get('nome')?.value;
    this.campeonatoDto.dataInicio = this.formulario.get('dataInicio')?.value;
    this.campeonatoDto.dataTermino = this.formulario.get('dataTermino')?.value;
    this.campeonatoDto.time = this.formulario.get('time')?.value;
    this.campeonatoDto.premiacao = this.formulario.get('premiacao')?.value;
    this.campeonatoDto.adm = this.formulario.get('adm')?.value;
    this.campeonatoDto.descricao = this.formulario.get('descricao')?.value;
    this.campeonatoDto.regra = this.formulario.get('regra')?.value;
    this.campeonatoDto.file = this.nameFile;
  }

}
