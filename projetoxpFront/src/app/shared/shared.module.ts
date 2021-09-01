import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './input-field/input-field.component';
import { ErrorMsgComponent } from './error-msg/error-msg.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TexteareaFieldComponent } from './textearea-field/textearea-field.component';
import { CurrencyMaskModule } from 'ngx-currency-mask';



@NgModule({
  declarations: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent
  ],
})
export class SharedModule { }

