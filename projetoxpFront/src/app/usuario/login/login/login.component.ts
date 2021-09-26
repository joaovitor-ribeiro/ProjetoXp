import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent extends BaseFormComponent implements OnInit {

  nick: string = ''
  senha: string = ''
  invalidLogin = false
  formulario!: FormGroup;

  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private formBuilder: FormBuilder,
    ) { super() }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      'nick': [null, [Validators.required, Validators.minLength(3), Validators.maxLength(35)]],
      'senha': [null, [Validators.required, Validators.minLength(6)]],
    });
  }

  submit() {
    this.nick = this.formulario.get('nick')?.value;
    this.senha = this.formulario.get('senha')?.value;
    if (this.loginservice.authenticate(this.nick, this.senha)
    ) {
      this.router.navigate(['campeonato'])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

}
