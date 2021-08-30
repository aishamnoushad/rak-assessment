import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchEmpListComponent } from './search-emp-list.component';

describe('SearchEmpListComponent', () => {
  let component: SearchEmpListComponent;
  let fixture: ComponentFixture<SearchEmpListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchEmpListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchEmpListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
