package mk.ukim.finki.meetingscheduler.infrastructure.repository;

import mk.ukim.finki.meetingscheduler.domain.model.Meeting;
import mk.ukim.finki.meetingscheduler.domain.model.Person;
import mk.ukim.finki.meetingscheduler.domain.model.Room;
import mk.ukim.finki.meetingscheduler.domain.valueobject.Capacity;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.PersonRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.RoomRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;

    public DataLoader(RoomRepository roomRepository, PersonRepository personRepository) {
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            Room room = new Room(i, new Capacity(10));
            roomRepository.save(room);
        }

//        this.personRepository.save(new Person("Andrej"));
//        this.personRepository.save(new Person("Stefan"));
//        this.personRepository.save(new Person("David"));
//        this.personRepository.save(new Person("Blagoja"));
    }
}
