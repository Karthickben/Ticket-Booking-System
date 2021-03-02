/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { UserSingInComponent } from './user-sing-in.component';

describe('UserSingInComponent', () => {
  let component: UserSingInComponent;
  let fixture: ComponentFixture<UserSingInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserSingInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSingInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
