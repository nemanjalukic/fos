import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatOptionModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterTestingModule } from '@angular/router/testing';

import { NewFoodItemComponent } from './new-food-item.component';

describe('NewFoodItemComponent', () => {
  let component: NewFoodItemComponent;
  let fixture: ComponentFixture<NewFoodItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewFoodItemComponent ],
      imports: [
        RouterTestingModule,
        HttpClientModule,
        FormsModule,
        BrowserModule,
        BrowserAnimationsModule,
        MatSelectModule,
        MatOptionModule,
        MatInputModule
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewFoodItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
