import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { Person } from 'src/app/models/person';
import { EmployeesService } from 'src/app/services/employees.service';
import { NewEmployeeComponent } from '../new-employee/new-employee.component';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styles: [`
    .mat-list-icon {
      color: rgba(0, 0, 0, 0.54);
    }
    button {
      margin-bottom: 10px;
    }
  `]
})
export class EmployeesComponent implements OnInit {

  employees!: Person[];

  constructor(
    private employeesService: EmployeesService,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  addEmployee() {
    this.dialog.open(NewEmployeeComponent)
      .afterClosed()
      .subscribe(
        () => this.loadEmployees()
      );
  }

  deleteEmployee(employeeId: string){
    this.employeesService
      .deleteEmployee(employeeId)
      .subscribe(
        () => this.loadEmployees()
      );
  }

  loadEmployees() {
    this.employeesService.getEmployees().subscribe(
      (employees) => this.employees = employees
    );
  }

}
