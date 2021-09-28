package mk.ukim.finki.meetingscheduler.domain.service;

import mk.ukim.finki.meetingscheduler.domain.dtos.MeetingDto;
import mk.ukim.finki.meetingscheduler.domain.exceptions.NotFoundException;
import mk.ukim.finki.meetingscheduler.domain.model.*;
import mk.ukim.finki.meetingscheduler.domain.valueobject.TimeSlot;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.MeetingRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.PersonRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;

    public MeetingService(MeetingRepository meetingRepository, RoomRepository roomRepository, PersonRepository personRepository) {
        this.meetingRepository = meetingRepository;
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }


    public Meeting createNewMeeting(MeetingDto meetingDto) {
        Room room = this.roomRepository.findById(new RoomId(meetingDto.getRoomId())).orElseThrow(() -> {
            throw new NotFoundException();
        });

        List<Person> personList = new ArrayList<>();

        meetingDto.getPersonDtoList().forEach((p) -> {
            personList.add(
                    this.personRepository.findById(new PersonId(p.getPersonId())).orElseThrow(() -> {
                        throw new NotFoundException();
                    }));
        });

        TimeSlot timeSlot = new TimeSlot(meetingDto.getStartDate(), meetingDto.getEndDate());

        Meeting meeting = new Meeting(timeSlot, personList);

        meetingRepository.save(meeting);

        room.addMeeting(meeting);

        roomRepository.save(room);

        return meeting;
    }

    public List<Meeting> getMeetings() {
        return meetingRepository.findAll();
    }

    public void employeeAdded(String employeeId, String employeeName) {
        System.out.println(this.personRepository.save(new Person(employeeId, employeeName)));
    }

    public void employeeRemoved(String employeeId) {
        List<Meeting> meetings =  meetingRepository.findAll();
        meetings.forEach(m -> m.getPersonList().removeIf(p -> p.getId().getId().equals(employeeId)));
        meetingRepository.saveAll(meetings);
        personRepository.deleteById(new PersonId(employeeId));
    }
}
