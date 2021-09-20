package mk.ukim.finki.users.infrastructure.repository;

import lombok.AllArgsConstructor;
import mk.ukim.finki.users.domain.enums.Department;
import mk.ukim.finki.users.domain.model.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final EmployeeRepository employeeRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        this.employeeRepository.save(new Employee("Andrej", Department.IT));
//        this.employeeRepository.save(new Employee("Stefan", Department.HR));
    }
}
