import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BaseFormComponent } from '../shared/base-form/base-form.component';
import { FormValidations } from '../shared/form-validations';
import { UsuarioDto } from './model/usuarioDto.model';
import { CadastroUsuarioService } from './service/cadastro-usuario.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent extends BaseFormComponent implements OnInit {

  usuarioDto: UsuarioDto = new UsuarioDto();

  constructor(
    private formBuilder: FormBuilder,
    private cadastroUsuarioService: CadastroUsuarioService,
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
    });
  }

  preenchendoUsuarioDto(){
    this.usuarioDto.nome  = this.formulario.get('nome')?.value;
    this.usuarioDto.nick  = this.formulario.get('nick')?.value;
    this.usuarioDto.email = this.formulario.get('email')?.value;
    this.usuarioDto.senha = this.formulario.get('senha')?.value;
  }

  submit() {
    this.preenchendoUsuarioDto();
    this.cadastroUsuarioService.cadastroUsuario(this.usuarioDto).subscribe(
      sucess => this.formulario.reset(),
      error => console.log('error'),
      () => console.log('request completo')
    );
  }

}
