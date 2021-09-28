import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Departments, EmployeeDto } from 'src/app/models/employeeDto';
import { EmployeesService } from 'src/app/services/employees.service';

@Component({
  selector: 'app-new-employee',
  templateUrl: './new-employee.component.html',
  styles: [
  ]
})
export class NewEmployeeComponent implements OnInit {

  name = new FormControl();
  department = new FormControl();

  departments: string[] = Object.keys(Departments).filter((val) => isNaN(Number(val)));

  constructor(private employeesService: EmployeesService) { }

  ngOnInit(): void {
  }

  addEmployee() {
    this.employeesService
      .createEmployee({
        employeeId: "",
        name: this.name.value,
        department: this.department.value
      })
      .subscribe();
  }

}
