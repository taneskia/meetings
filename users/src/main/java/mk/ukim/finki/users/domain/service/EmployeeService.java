package mk.ukim.finki.users.domain.service;

import mk.ukim.finki.users.domain.dtos.EmployeeDto;
import mk.ukim.finki.users.domain.enums.Department;
import mk.ukim.finki.shared.domain.events.EmployeeAdded;
import mk.ukim.finki.users.domain.model.Employee;
import mk.ukim.finki.users.domain.model.EmployeeId;
import mk.ukim.finki.shared.domain.events.EmployeeRemoved;
import mk.ukim.finki.users.infrastructure.events.EventPublisher;
import mk.ukim.finki.users.infrastructure.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EventPublisher eventPublisher;

    public EmployeeService(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
        this.employeeRepository = employeeRepository;
        this.eventPublisher = eventPublisher;
    }

    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee createEmployee(EmployeeDto employeeDto) {
        Employee employee = this.employeeRepository.save(new Employee(employeeDto.getName(), Department.valueOf(employeeDto.getDepartment())));
        this.eventPublisher.publish(new EmployeeAdded(employee.getId().getId(), employee.getName()));
        return employee;
    }

    public void removeEmployee(String employeeId) {
        this.employeeRepository.deleteById(new EmployeeId(employeeId));
        this.eventPublisher.publish(new EmployeeRemoved(employeeId));
    }
}
