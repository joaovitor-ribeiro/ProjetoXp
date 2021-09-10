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

  email: string = ''
  senha: string = ''
  invalidLogin = false
  formulario!: FormGroup;

  constructor(private router: Router,
    private loginservice: AuthenticationService,
    private formBuilder: FormBuilder,
    ) { super() }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      'email': [null, [Validators.required,Validators.email]],
      'senha': [null, [Validators.required, Validators.minLength(6)]],
    });
  }

  submit() {
    if (this.loginservice.authenticate(this.email, this.senha)
    ) {
      this.router.navigate([''])
      this.invalidLogin = false
    } else
      this.invalidLogin = true
  }

}
