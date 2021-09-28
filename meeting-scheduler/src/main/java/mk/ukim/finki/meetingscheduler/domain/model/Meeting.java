package mk.ukim.finki.meetingscheduler.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mk.ukim.finki.meetingscheduler.domain.dtos.MeetingDto;
import mk.ukim.finki.meetingscheduler.domain.exceptions.InvalidValueException;
import mk.ukim.finki.meetingscheduler.domain.valueobject.TimeSlot;
import mk.ukim.finki.shared.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "meeting")
@Getter
public class Meeting extends BaseEntity<MeetingId> {

    @Embedded
    private TimeSlot timeSlot;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Person> personList;

    protected Meeting() { super(MeetingId.randomId(MeetingId.class)); }

    public Meeting(TimeSlot timeSlot, List<Person> personList) {
        super(MeetingId.randomId(MeetingId.class));
        this.timeSlot = timeSlot;
        this.personList = personList;
    }
}
