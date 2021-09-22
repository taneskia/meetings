package mk.ukim.finki.meetingscheduler.domain.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.exceptions.NotFoundException;
import mk.ukim.finki.meetingscheduler.domain.model.Person;
import mk.ukim.finki.meetingscheduler.domain.model.Room;
import mk.ukim.finki.meetingscheduler.domain.model.RoomId;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.PersonRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getPeople() {
        return this.personRepository.findAll();
    }
}