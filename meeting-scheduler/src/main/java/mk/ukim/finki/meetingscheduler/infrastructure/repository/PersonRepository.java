package mk.ukim.finki.meetingscheduler.infrastructure.repository;

import mk.ukim.finki.meetingscheduler.domain.model.Person;
import mk.ukim.finki.meetingscheduler.domain.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
}
