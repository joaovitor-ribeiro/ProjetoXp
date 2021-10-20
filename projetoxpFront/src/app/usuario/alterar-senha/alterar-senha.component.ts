import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { BaseFormComponent } from 'src/app/shared/base-form/base-form.component';

@Component({
  selector: 'app-alterar-senha',
  templateUrl: './alterar-senha.component.html',
  styleUrls: ['./alterar-senha.component.css']
})
export class AlterarSenhaComponent extends BaseFormComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
  ) {
    super();
  }

  ngOnInit() {
    this.formulario = this.formBuilder.group({
      'senhaAntiga': [null, [Validators.required, Validators.minLength(6)]],
      'senhaNova': [null, [Validators.required, Validators.minLength(6)]],
      'senhaNovaRepetida': [null, [Validators.required, Validators.minLength(6)]],
    });
  }

  submit() {

  }
}
