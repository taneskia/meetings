package mk.ukim.finki.users.domain.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EmployeeDto {

    private String employeeId;

    private String name;

    private String department;

    @JsonCreator
    public EmployeeDto(
            @JsonProperty("employeeId") String employeeId,
            @JsonProperty("name") String name,
            @JsonProperty("department") String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }
}
