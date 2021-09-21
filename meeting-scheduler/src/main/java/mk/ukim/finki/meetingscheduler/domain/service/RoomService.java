package mk.ukim.finki.meetingscheduler.domain.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.dtos.MeetingDto;
import mk.ukim.finki.meetingscheduler.domain.exceptions.InvalidValueException;
import mk.ukim.finki.meetingscheduler.domain.exceptions.NotFoundException;
import mk.ukim.finki.meetingscheduler.domain.model.*;
import mk.ukim.finki.meetingscheduler.domain.valueobject.TimeSlot;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.PersonRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final MeetingService meetingService;
    private final PersonRepository personRepository;

    public List<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    public Room getRoom(String roomId) {
        return this.roomRepository.findById(new RoomId(roomId)).orElseThrow(() -> {
            throw new NotFoundException();
        } );
    }

    public Meeting createMeeting(MeetingDto meetingDto) {
        Room room = this.roomRepository.findById(new RoomId(meetingDto.getRoomId())).orElseThrow(() -> {
            throw new NotFoundException();
        });

        if(room.getCapacity().getValue() < meetingDto.getPersonDtoList().size())
            throw new InvalidValueException();


        List<Person> personList = new ArrayList<>();

        meetingDto.getPersonDtoList().forEach((p) -> {
            personList.add(
                    this.personRepository.findById(new PersonId(p.getPersonId())).orElseThrow(() -> {
                        throw new NotFoundException();
                    }));
        });

        TimeSlot timeSlot = new TimeSlot(meetingDto.getStartDate(), meetingDto.getEndDate());

        Meeting meeting = new Meeting(timeSlot, personList);

        room.addMeeting(meeting);

        roomRepository.save(room);

        return meeting;
    }
}
