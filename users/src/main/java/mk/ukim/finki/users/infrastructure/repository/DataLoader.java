package mk.ukim.finki.users.infrastructure.repository;

import lombok.AllArgsConstructor;
import mk.ukim.finki.users.domain.dtos.EmployeeDto;
import mk.ukim.finki.users.domain.enums.Department;
import mk.ukim.finki.users.domain.model.Employee;
import mk.ukim.finki.users.domain.service.EmployeeService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (this.employeeRepository.count() == 0) {
            this.employeeService.createEmployee(new EmployeeDto("", "Andrej", "IT"));
            this.employeeService.createEmployee(new EmployeeDto("", "Stefan", "HR"));
            this.employeeService.createEmployee(new EmployeeDto("", "David", "PR"));
            this.employeeService.createEmployee(new EmployeeDto("", "Blagoja", "CR"));
        }
    }

}
