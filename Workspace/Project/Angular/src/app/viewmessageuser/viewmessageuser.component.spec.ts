import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewmessageuserComponent } from './viewmessageuser.component';

describe('ViewmessageuserComponent', () => {
  let component: ViewmessageuserComponent;
  let fixture: ComponentFixture<ViewmessageuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewmessageuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewmessageuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
