package mk.ukim.finki.meetingscheduler.domain.model;

import lombok.Getter;
import mk.ukim.finki.shared.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "person")
@Getter
public class Person extends BaseEntity<PersonId> {

    private String name;

    protected Person() { super(PersonId.randomId(PersonId.class)); }

    public Person(String name) {
        super(PersonId.randomId(PersonId.class));
        this.name = name;
    }

    public Person(String id, String name) {
        super(new PersonId(id));
        this.name = name;
    }
}
