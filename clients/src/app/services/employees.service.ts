import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
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
}
