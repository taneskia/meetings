package mk.ukim.finki.meetingscheduler.domain.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MeetingDto {

    private String roomId;

    private Date startDate;

    private Date endDate;

    private List<PersonDto> personDtoList;

    @JsonCreator
    public MeetingDto(
            @JsonProperty("roomId") String roomId,
            @JsonProperty("startDate") Date startDate,
            @JsonProperty("endDate") Date endDate, List<PersonDto> personDtoList) {
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.personDtoList = personDtoList;
    }
}
