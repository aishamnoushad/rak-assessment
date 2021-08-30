import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Department } from '../department';

import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employeeForm = new FormGroup({
    id: new FormControl(''),
    employeeName: new FormControl(''),
    dateOfJoining: new FormControl(''),
    department: new FormControl(''),
    salary: new FormControl(''),
   
  });
  employeeDetailsForm !: FormGroup;
  validation_messages = {
    'id': [
      { type: 'required', message: 'Employee Number is required' },
      {type: 'maxlength', message: 'Employee Number cannot be more than 10 digits '}
    ],
    'employeeName': [
      { type: 'required', message: 'Employee Number is required' },
    ],
    'department': [
      { type: 'required', message: 'Please select your Department' },
    ],
    'dateOfJoining': [
      { type: 'required', message: 'Please insert your Date of Joining' },
    ],
    'salary': [
      { type: 'required', message: 'Salary is required' },
     
    ]
  };
  employee: Employee = new Employee();
  departments : Department[]=[];
  
  constructor(private employeeService: EmployeeService,
    private router: Router,private fb: FormBuilder) {
      this.createForms();
     }

  ngOnInit(): void {
    this.getDepartments();
    
  }

  createForms(){
    this.employeeDetailsForm = this.fb.group({
      id: ['', new FormControl (Validators.required ,Validators.maxLength(10))],
      employeeName: ["", Validators.required],
      dateOfJoining: ['', Validators.required],
      department: new FormControl(this.departments[0], Validators.required),
      salary: ['', Validators.required],
    });
  }
  getDepartments(){
    this.employeeService.getDepartmentList().subscribe(data => {
      this.departments = data;
    });
  }
  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }
  
  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }
}

