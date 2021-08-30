import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { FormsModule ,ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { SearchComponent } from './search/search.component';
import { SearchEmpListComponent } from './search-emp-list/search-emp-list.component';
import { EmpSearchComponent } from './emp-search/emp-search.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    SearchComponent,
    SearchEmpListComponent,
    EmpSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
      BrowserModule,
      FormsModule,
      ReactiveFormsModule,
      BsDatepickerModule.forRoot(),
      HttpClientModule,
      
      
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
