import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { UploadFileService } from 'src/app/campeonato/service/upload-file.service';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';
import { FormValidations } from 'src/app/shared/form-validations';
import { UsuarioDto } from '../model/usuarioDto.model';
import { UsuarioFormService } from '../service/usuario.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent extends BaseFormComponent implements OnInit {

  usuarioDto: UsuarioDto = new UsuarioDto();
  files: File | undefined;
  nameFile: string = '';
  editar: boolean = false;
  nick!: string;
  inscricao!: Subscription;
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'top';

  constructor(
    private formBuilder: FormBuilder,
    private usuarioFormService: UsuarioFormService,
    private service: UploadFileService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
    super();
  }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      'nome': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
      'nick': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
      'email': [null, [Validators.required,Validators.email]],
      'confirmarEmail': [null, [Validators.required, FormValidations.equalsTo('email')]],
      'senha': [null, [Validators.required, Validators.minLength(6)]],
      'confirmarSenha': [null, [Validators.required, FormValidations.equalsTo('senha')]],
      'file': [null, []],
    });

    this.inscricao = this.route.data.subscribe(
      (usuario) => {
        if(usuario.form != undefined){
          this.usuarioDto = (usuario.form);
          this.populaDadosForm(usuario.form);
          this.editar = true;
          this.formulario.get('senha')?.disable();
          this.formulario.get('confirmarSenha')?.disable();
          this.route.params.subscribe(params => {
            this.nick = params['nick'];
          })
        }
      }
    );
  }

  populaDadosForm(usuario: UsuarioDto) {
    this.formulario.patchValue({
      nome: usuario.nome,
      nick: usuario.nick,
      email: usuario.email,
      senha: usuario.senha,
      file: usuario.file
    });
    this.nameFile = usuario.file;
  }

  onChange(event: any) {
    this.nameFile = event.srcElement.files[0].name;
    this.files = event.srcElement.files[0];
  }

  onUpload() {
    if (this.files && this.files.size > 0) {
      this.service.upload(this.files, 'usuario');
    }
  }

  preenchendoUsuarioDto(){
    this.usuarioDto.nome  = this.formulario.get('nome')?.value;
    this.usuarioDto.nick  = this.formulario.get('nick')?.value;
    this.usuarioDto.email = this.formulario.get('email')?.value;
    this.usuarioDto.senha = this.formulario.get('senha')?.value;
    this.usuarioDto.file  = this.nameFile;
  }

  submit() {
    console.log('saggassdAsafsagahgdfhfgjhgkjhkhjgga');
    this.preenchendoUsuarioDto();
    if(this.editar){
      if(this.nameFile !== this.formulario.get('file')?.value){
        this.onUpload();
      }
      console.log('testes');
      this.usuarioFormService.atualizarUsuario(this.nick,this.usuarioDto).subscribe(
        result => {
          if(result){
           this.openSnackBar('Usuario atualizado com sucesso');
           this.router.navigate(['login']);
          }else{
           this.openSnackBar('Usuario já cadastrado');
          }
        }
      );
    }else{
      if(this.nameFile !== this.formulario.get('file')?.value){
        this.onUpload();
      }
      this.usuarioFormService.cadastroUsuario(this.usuarioDto).subscribe(
       result => {
         if(result){
          this.openSnackBar('Usuario cadastrado com sucesso');
          this.router.navigate(['login']);
         }else{
          this.openSnackBar('Usuario já cadastrado');
         }
       }
      );
    }
  }

  openSnackBar(text: string) {
    this.snackBar.open(text, '', {
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      duration: 1500,
    });
  }

}
