/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { UserSingUpComponent } from './user-sing-up.component';

describe('UserSingUpComponent', () => {
  let component: UserSingUpComponent;
  let fixture: ComponentFixture<UserSingUpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserSingUpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSingUpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
