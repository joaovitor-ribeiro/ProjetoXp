import { Component, forwardRef, Input, OnInit } from '@angular/core';
import { NG_VALUE_ACCESSOR } from '@angular/forms';

const INPUT_FIELD_VALUE_ACCESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => InputFieldComponent),
  multi: true
};
@Component({
  selector: 'app-input-field',
  templateUrl: './input-field.component.html',
  styleUrls: ['./input-field.component.css'],
  providers: [INPUT_FIELD_VALUE_ACCESSOR]
})
export class InputFieldComponent implements OnInit {

  @Input() classeCssLabel: any;
  @Input() classeCssInput: any;
  @Input() id!: string;
  @Input() label!: string;
  @Input() mask!: string;
  @Input() type = 'text';
  @Input() control: any;
  @Input() isReadOnly = false;
  isPrimiacao = false;

  private innerValue: any;

  constructor() { }

  ngOnInit(): void {
  }

  get value() {
    return this.innerValue;
  }

  set value(v: any) {
    if (v !== this.innerValue) {
      this.innerValue = v;
      this.onChangeCb(v);
    }
  }

  onChangeCb: (_: any) => void = () => {};
  onTouchedCb: (_: any) => void = () => {};

  writeValue(v: any): void {
    this.value = v ;
  }

  registerOnChange(fn: any): void {
    this.onChangeCb = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouchedCb = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this.isReadOnly = isDisabled;
  }

  mascara(id: any){
    if(id != 'premiacao'){
      this.isPrimiacao = false;
      this.mask = '';
    }else{
      this.isPrimiacao = true;
      this.mask = '0.000.000.00';
    }
  }

}
