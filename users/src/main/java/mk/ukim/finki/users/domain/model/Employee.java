package mk.ukim.finki.users.domain.model;

import lombok.Getter;
import mk.ukim.finki.shared.domain.model.BaseEntity;
import mk.ukim.finki.users.domain.enums.Department;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "employee")
public class Employee extends BaseEntity<EmployeeId> {

    private String name;

    @Enumerated(EnumType.STRING)
    private Department department;

    protected Employee() { super(EmployeeId.randomId(EmployeeId.class)); }

    public Employee(String name, Department department) {
        super(EmployeeId.randomId(EmployeeId.class));
        this.name = name;
        this.department = department;
    }
}
