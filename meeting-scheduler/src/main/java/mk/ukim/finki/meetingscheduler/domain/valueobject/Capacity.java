package mk.ukim.finki.meetingscheduler.domain.valueobject;

import lombok.Getter;
import mk.ukim.finki.meetingscheduler.domain.exceptions.InvalidValueException;
import mk.ukim.finki.shared.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Capacity implements ValueObject {
    private final int value;

    public Capacity(int value) {
        if(value > 50)
            throw new InvalidValueException();
        this.value = value;
    }

    public Capacity() {
        this.value = 0;
    }
}
