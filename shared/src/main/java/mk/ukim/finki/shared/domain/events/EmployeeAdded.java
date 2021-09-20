package mk.ukim.finki.shared.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.shared.domain.config.Topics;
import mk.ukim.finki.shared.domain.events.DomainEvent;

@Getter
public class EmployeeAdded extends DomainEvent {

    private String employeeId;
    private String name;

    public EmployeeAdded() {
        super(Topics.EMPLOYEE_ADDED);
    }

    @JsonCreator
    public EmployeeAdded(@JsonProperty("employeeId") String employeeId, @JsonProperty("name") String name) {
        super(Topics.EMPLOYEE_ADDED);
        this.employeeId = employeeId;
        this.name = name;
    }
}
