import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TexteareaFieldComponent } from './textearea-field.component';

describe('TexteareaFieldComponent', () => {
  let component: TexteareaFieldComponent;
  let fixture: ComponentFixture<TexteareaFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TexteareaFieldComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TexteareaFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
