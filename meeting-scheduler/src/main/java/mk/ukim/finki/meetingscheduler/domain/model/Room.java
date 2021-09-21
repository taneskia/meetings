package mk.ukim.finki.meetingscheduler.domain.model;


import lombok.Getter;
import mk.ukim.finki.meetingscheduler.domain.valueobject.Capacity;
import mk.ukim.finki.meetingscheduler.domain.valueobject.TimeSlot;
import mk.ukim.finki.shared.domain.model.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "room")
@Entity
@Getter
public class Room extends BaseEntity<RoomId> {

    @Column(unique = true)
    private int number;

    @Embedded
    private Capacity capacity;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Meeting> meetings;

    protected Room() { super(RoomId.randomId(RoomId.class)); }

    public Room(int number, Capacity capacity) {
        super(RoomId.randomId((RoomId.class)));
        this.number = number;
        this.capacity = capacity;
    }

    public void addMeeting(Meeting meeting){
        this.meetings.add(meeting);
    }
}
