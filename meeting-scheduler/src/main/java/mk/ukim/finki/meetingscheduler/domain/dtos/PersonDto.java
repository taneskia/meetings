package mk.ukim.finki.meetingscheduler.domain.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonDto {

    private String personId;

    private String name;

    @JsonCreator
    public PersonDto(@JsonProperty("personId") String personId, @JsonProperty("name") String name) {
        this.personId = personId;
        this.name = name;
    }
}
