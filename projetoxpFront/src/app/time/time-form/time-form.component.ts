import { Component, OnInit } from '@angular/core';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';
import { FormBuilder, Validators } from '@angular/forms';
import { UploadFileService } from 'src/app/campeonato/service/upload-file.service';
import { ActivatedRoute } from '@angular/router';
import { TimeService } from '../service/time.service';
import { Time } from '../model/time.model';

@Component({
  selector: 'app-time-form',
  templateUrl: './time-form.component.html',
  styleUrls: ['./time-form.component.css']
})
export class TimeFormComponent extends BaseFormComponent implements OnInit {

  time: Time = new Time();
  files: File | undefined;
  nameFile: string = '';
  id!: number;

  constructor(
    private timeService: TimeService,
    private formBuilder: FormBuilder,
    private service: UploadFileService,
    private route: ActivatedRoute,
  ) {
    super();
  }

  ngOnInit(): void {

    this.route.params.subscribe(params =>{
      this.id = params['id'];
    });

    this.formulario = this.formBuilder.group({
      'nome': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
      'capitao': [null, []],
      'jogador2': [null, []],
      'jogador3': [null, []],
      'jogador4': [null, []],
      'jogador5': [null, []],
      'file': [null, []],
    });
  }

  submit() {
    this.preenchendoTime();
    if(this.nameFile != ''){
      this.onUpload();
    }
    this.timeService.cadastrarTime(this.id, this.time).subscribe(
      sucess => (this.formulario.reset()),
      error => console.log('error'),
      () => console.log('request completo')
    );
  }

  onChange(event: any) {
    this.nameFile = event.srcElement.files[0].name;
    this.files = event.srcElement.files[0];
  }

  onUpload() {
    if (this.files && this.files.size > 0) {
      this.service.upload(this.files, 'time');
    }
  }

  preenchendoTime() {
    this.time.timeCapitao  = this.formulario.get('nome')?.value + this.formulario.get('capitao')?.value;
    this.time.idCampeonato = this.id;
    this.time.nome         = this.formulario.get('nome')?.value;
    this.time.capitao      = this.formulario.get('capitao')?.value;
    this.time.jogador2     = this.formulario.get('jogador2')?.value;
    this.time.jogador3     = this.formulario.get('jogador3')?.value;
    this.time.jogador4     = this.formulario.get('jogador4')?.value;
    this.time.jogador5     = this.formulario.get('jogador5')?.value;
    this.time.file         = this.nameFile;
  }
}
