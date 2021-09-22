package mk.ukim.finki.meetingscheduler.domain.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.model.Meeting;
import mk.ukim.finki.meetingscheduler.domain.model.Person;
import mk.ukim.finki.meetingscheduler.domain.service.PersonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("")
    public List<Person> getPeople() {
        return this.personService.getPeople();
    }
}
