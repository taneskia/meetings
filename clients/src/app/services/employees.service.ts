import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { EmployeeDto } from '../models/employeeDto';
import { Person } from '../models/person';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  private employeesApiUrl = environment.employees_api;

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Person[]> {
    return this.http.get<Person[]>(this.employeesApiUrl);
  }

  createEmployee(employeeDto: EmployeeDto) {
    return this.http.post<EmployeeDto>(this.employeesApiUrl, employeeDto);
  }

  deleteEmployee(employeeId: string) {
    return this.http.delete(this.employeesApiUrl + "/" + employeeId);
  }
}
