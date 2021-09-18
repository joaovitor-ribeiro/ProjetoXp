import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './input-field/input-field.component';
import { ErrorMsgComponent } from './error-msg/error-msg.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TexteareaFieldComponent } from './textearea-field/textearea-field.component';
import { SelectFieldComponent } from './select-field/select-field.component';
import { NgxMaskModule } from 'ngx-mask';



@NgModule({
  declarations: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    SelectFieldComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMaskModule,
    NgxMaskModule.forRoot(),
  ],
  exports: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    SelectFieldComponent
  ],
})
export class SharedModule { }

