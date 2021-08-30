

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Employee } from './employee';
import { Department } from './department';
import { Observable, of, Subject } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  setGroupFilter$ = new Subject<any>();
  getGroupFilter = this.setGroupFilter$.asObservable();
  private baseURL = "http://localhost:8180/api/v1/employees";

  constructor(private httpClient: HttpClient) { }
  getDepartmentList(): Observable<Department[]>{
    return this.httpClient.get<Department[]>(`${this.baseURL}/department`);
  }

  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  getEmployeeByIdAndName(id: number, name:string): Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}/${name}`);
  }
}
