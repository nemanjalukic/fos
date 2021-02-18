import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatMenuModule } from '@angular/material/menu';
import { RouterTestingModule } from '@angular/router/testing';

import { ResponsiveToolbarComponent } from './responsive-toolbar.component';

describe('ResponsiveToolbarComponent', () => {
  let component: ResponsiveToolbarComponent;
  let fixture: ComponentFixture<ResponsiveToolbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsiveToolbarComponent ],
      imports: [
        RouterTestingModule,
        HttpClientModule,
        MatMenuModule
      ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResponsiveToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
