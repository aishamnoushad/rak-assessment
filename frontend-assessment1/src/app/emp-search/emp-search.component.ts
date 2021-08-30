import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Search } from '../search';

@Component({
  selector: 'app-emp-search',
  templateUrl: './emp-search.component.html',
  styleUrls: ['./emp-search.component.css']
})
export class EmpSearchComponent implements OnInit {
  id !: number;
  employeeName !: string;
  employee: Employee = new Employee;
  search : Search = new Search;
  constructor(private route: ActivatedRoute, private employeService: EmployeeService) { }

  ngOnInit(): void {
    
    
    // this.employeService.getEmployeeById(this.id).subscribe( data => {
    //   this.employee = data;
    // });
  }
  onSubmit(){
    this.employeService.getEmployeeByIdAndName(this.search.id,this.search.employeeName).subscribe(data => {
      this.employee = data;
    });
    
    
  }

}
