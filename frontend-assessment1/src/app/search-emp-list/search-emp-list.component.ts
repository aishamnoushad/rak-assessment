import { Component, OnInit ,Input, OnChanges, ChangeDetectorRef} from '@angular/core';
import { Observable } from 'rxjs';
import { filter } from 'rxjs/operators';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-search-emp-list',
  templateUrl: './search-emp-list.component.html',
  styleUrls: ['./search-emp-list.component.css']
})
export class SearchEmpListComponent implements OnInit {
  @Input() groupFilters !: Object;
  @Input() searchByKeyword !: string;

  employees: Employee[] =[];
  filteredEmployees: Employee[] = [];
  constructor(private employeeService: EmployeeService,
    private ref: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadEmployees();
  }
  ngOnChanges(): void {
   // if (this.groupFilters) this.filterUserList(this.groupFilters, this.employees);
  }

  filterUserList(filters: any, employees: Employee): void {
    this.filteredEmployees = this.employees;     //Reset User List

    const keys = Object.keys(filters);
    //const filterEmployee = employee => keys.every(key => employee[key] === filters[key]);

   // this.filteredEmployees = this.employees.filter(filterEmployee);

    this.ref.detectChanges();
  }

  loadEmployees(): void {
  // this.employees= this.employeeService.getEmployeesList();
                    

    this.filteredEmployees = this.filteredEmployees.length > 0 ? this.filteredEmployees : this.employees;                
  }


}







