import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './input-field/input-field.component';
import { ErrorMsgComponent } from './error-msg/error-msg.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TexteareaFieldComponent } from './textearea-field/textearea-field.component';
import { NgxMaskModule } from 'ngx-mask';
import { DatapickerComponent } from './datapicker/datapicker.component';



@NgModule({
  declarations: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    DatapickerComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMaskModule,
    NgxMaskModule.forRoot(),
  ],
  exports: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    DatapickerComponent,
  ],
})
export class SharedModule { }

