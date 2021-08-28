import { CadastroCampeonatoService } from './service/cadastro-campeonato.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BaseFormComponent } from '../shared/base-form/base-form.component';
import { CampeonatoDto } from './model/campeonatoDto.model';
import { UploadFileService } from './service/upload-file.service';

@Component({
  selector: 'app-cadastro-campeonato',
  templateUrl: './cadastro-campeonato.component.html',
  styleUrls: ['./cadastro-campeonato.component.css']
})
export class CadastroCampeonatoComponent extends BaseFormComponent implements OnInit {

  files: File | undefined;
  nameFile!: string;
  campeonatoDto: CampeonatoDto = new CampeonatoDto()

  constructor(
    private formBuilder: FormBuilder,
    private cadastroCampeonatoService: CadastroCampeonatoService,
    private service: UploadFileService
  ) {
    super();
  }

  ngOnInit(): void {
    this.formulario = this.formBuilder.group({
      'nome': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
      'dataInicio': [null, [Validators.required]],
      'dataTermino': [null, [Validators.required]],
      'time': [null, [Validators.required]],
      'premiacao': [null, [Validators.required]],
      'adm': [null, [Validators.required]],
      'regra': [null, [Validators.required]],
      'file': [null, []],
    });
  }

  onChange(event: any) {
    this.nameFile = event.srcElement.files[0].name;
    this.files = event.srcElement.files[0];
  }

  onUpload(){
    if (this.files && this.files.size > 0) {
      this.service.upload(this.files);
    }
  }

  submit() {
    this.preenchendoUsuarioDto();
    this.onUpload();
    this.cadastroCampeonatoService.cadastroCampeonato(this.campeonatoDto).subscribe(
      sucess => this.formulario.reset(),
      error => console.log('error'),
      () => console.log('request completo')
    );
  }

  preenchendoUsuarioDto(){
    this.campeonatoDto.nome         = this.formulario.get('nome')?.value;
    this.campeonatoDto.dataInicio   = this.formulario.get('dataInicio')?.value;
    this.campeonatoDto.dataTermino  = this.formulario.get('dataTermino')?.value;
    this.campeonatoDto.time         = this.formulario.get('time')?.value;
    this.campeonatoDto.premiacao    = this.formulario.get('premiacao')?.value;
    this.campeonatoDto.adm          = this.formulario.get('adm')?.value;
    this.campeonatoDto.regra        = this.formulario.get('regra')?.value;
    this.campeonatoDto.file         = this.nameFile;
  }
}
