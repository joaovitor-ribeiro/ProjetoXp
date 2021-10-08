import { TimeDto } from './../model/time.model';
import { Component, OnInit } from '@angular/core';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';
import { FormBuilder, Validators } from '@angular/forms';
import { UploadFileService } from 'src/app/campeonato/service/upload-file.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TimeService } from '../service/time.service';
import { Time } from '../model/time.model';
import { AuthenticationService } from './../../usuario/service/authentication.service';
import { Observable } from 'rxjs';

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
  idTime!: string;
  usuario!: any;
  time$!: Observable<Time[]>
  edit = false;
  semTime = false;

  constructor(
    private timeService: TimeService,
    private formBuilder: FormBuilder,
    private service: UploadFileService,
    private route: ActivatedRoute,
    private router: Router,
    private login: AuthenticationService
  ) {
    super();
  }

  ngOnInit(): void {

    this.usuario = this.login.getSessionNick();

    this.route.params.subscribe(params =>{
      this.id = params['id'];
      if(params['timeCapitao']){
        this.edit = true;
        this.idTime = params['timeCapitao'];
      }
      this.timeService.getTime(params['id'], params['timeCapitao']).subscribe(result => {
        if(result){
          this.preencheFormulario(result);
        }else{
          this.semTime = true;
        }
      })
    });

    this.time$ = this.timeService.listarTimeByUsuario(this.usuario);

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

  preencheFormulario(time: any){
    this.formulario.patchValue({
      nome: time.nome,
      capitao: time.capitao,
      jogador2: time.jogador2,
      jogador3: time.jogador3,
      jogador4: time.jogador4,
      jogador5: time.jogador5,
      file: time.file,
    });
  }

  submit() {
    this.preenchendoTime();
    if(this.edit){
      if(this.nameFile != this.formulario.get('file')?.value){
        this.onUpload();
      }
      this.timeService.editarTime(this.id, this.idTime, this.time).subscribe(
        sucess =>  {
          alert('Time editado com sucesso'),
          this.router.navigate(['campeonato/detalhes/', this.id])
        },
        error => console.log('error'),
        () => console.log('request completo')
      );
    }else{
      if(this.nameFile != ''){
        this.onUpload();
      }
      this.timeService.cadastrarTime(this.id, this.time).subscribe(
        sucess => {
          alert('Time cadastrado com sucesso'),
          this.router.navigate(['campeonato/detalhes/', this.id])
        },
        error => console.log('error'),
        () => console.log('request completo')
      );
    }
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
