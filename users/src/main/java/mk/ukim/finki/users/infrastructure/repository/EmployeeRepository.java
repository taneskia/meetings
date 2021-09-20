package mk.ukim.finki.users.infrastructure.repository;

import mk.ukim.finki.users.domain.model.Employee;
import mk.ukim.finki.users.domain.model.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
}