import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from 'src/app/models/person';
import { EmployeesService } from 'src/app/services/employees.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styles: [`
    .mat-list-icon {
      color: rgba(0, 0, 0, 0.54);
    }
  `]
})
export class EmployeesComponent implements OnInit {

  employees!: Observable<Person[]>;

  constructor(private employeesService: EmployeesService) { }

  ngOnInit(): void {
    this.employees = this.employeesService.getEmployees();
  }

}
