import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewuserproductComponent } from './viewuserproduct.component';

describe('ViewuserproductComponent', () => {
  let component: ViewuserproductComponent;
  let fixture: ComponentFixture<ViewuserproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewuserproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewuserproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
