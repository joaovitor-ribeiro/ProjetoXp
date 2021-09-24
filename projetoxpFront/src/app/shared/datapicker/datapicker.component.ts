import { Component, ElementRef, Input, OnInit, Renderer2 } from '@angular/core';
import { ControlValueAccessor } from '@angular/forms';

@Component({
  selector: 'app-datapicker',
  templateUrl: './datapicker.component.html',
})
export class DatapickerComponent implements OnInit, ControlValueAccessor {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() classeCssLabel: any;
  @Input() classeCssInput: any;
  @Input() id!: string;
  @Input() label!: string;
  @Input() mask!: string;
  @Input() type = 'text';
  @Input() control: any;
  @Input() isReadOnly = false;

  private innerValue: any;

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

}
