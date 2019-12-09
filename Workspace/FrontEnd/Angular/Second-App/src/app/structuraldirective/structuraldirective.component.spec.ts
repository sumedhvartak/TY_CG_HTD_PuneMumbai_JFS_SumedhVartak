import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StructuraldirectiveComponent } from './structuraldirective.component';

describe('StructuraldirectiveComponent', () => {
  let component: StructuraldirectiveComponent;
  let fixture: ComponentFixture<StructuraldirectiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StructuraldirectiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StructuraldirectiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
