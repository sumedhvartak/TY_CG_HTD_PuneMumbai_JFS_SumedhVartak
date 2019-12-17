import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSendMessageComponent } from './user-send-message.component';

describe('UserSendMessageComponent', () => {
  let component: UserSendMessageComponent;
  let fixture: ComponentFixture<UserSendMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserSendMessageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSendMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
