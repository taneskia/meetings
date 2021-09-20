package mk.ukim.finki.users.domain.controller;

import mk.ukim.finki.users.domain.dtos.EmployeeDto;
import mk.ukim.finki.users.domain.model.Employee;
import mk.ukim.finki.users.domain.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getEmployees() {
        return this.employeeService.getEmployees();
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.createEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable String id) {
        this.employeeService.removeEmployee(id);
    }
}
