package mk.ukim.finki.shared.domain.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.shared.domain.config.Topics;

@Getter
public class EmployeeRemoved extends DomainEvent {

    private String employeeId;

    public EmployeeRemoved() {
        super(Topics.EMPLOYEE_REMOVED);
    }

    @JsonCreator
    public EmployeeRemoved(@JsonProperty("employeeId") String employeeId) {
        super(Topics.EMPLOYEE_REMOVED);
        this.employeeId = employeeId;
    }
}
