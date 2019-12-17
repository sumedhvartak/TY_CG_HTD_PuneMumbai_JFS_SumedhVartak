import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddmessageUserComponent } from './addmessage-user.component';

describe('AddmessageUserComponent', () => {
  let component: AddmessageUserComponent;
  let fixture: ComponentFixture<AddmessageUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddmessageUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddmessageUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
