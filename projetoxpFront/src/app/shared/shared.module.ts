import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputFieldComponent } from './input-field/input-field.component';
import { ErrorMsgComponent } from './error-msg/error-msg.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TexteareaFieldComponent } from './textearea-field/textearea-field.component';
import { SelectFieldComponent } from './select-field/select-field.component';
import { NgxMaskModule } from 'ngx-mask';
import {MatInputModule} from '@angular/material/input';
import { DatapickerComponent } from './datapicker/datapicker.component';



@NgModule({
  declarations: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    SelectFieldComponent,
    DatapickerComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxMaskModule,
    NgxMaskModule.forRoot(),
    MatInputModule,
  ],
  exports: [
    ErrorMsgComponent,
    InputFieldComponent,
    TexteareaFieldComponent,
    SelectFieldComponent,
    DatapickerComponent,
  ],
})
export class SharedModule { }

