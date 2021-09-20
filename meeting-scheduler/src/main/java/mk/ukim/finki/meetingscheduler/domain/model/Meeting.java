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

    @ManyToOne
    @JoinColumn(name = "room_")
    private Room room;

    @Embedded
    private TimeSlot timeSlot;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Person> personList;

    protected Meeting() { super(MeetingId.randomId(MeetingId.class)); }

    public Meeting(Room room, TimeSlot timeSlot, List<Person> personList) {
        super(MeetingId.randomId(MeetingId.class));
        this.room = room;
        this.timeSlot = timeSlot;

        if(personList.size() > room.getCapacity().getValue())
            throw new InvalidValueException();

        this.personList = personList;
    }
}
