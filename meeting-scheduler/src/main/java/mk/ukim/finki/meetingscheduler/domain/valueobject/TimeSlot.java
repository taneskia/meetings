package mk.ukim.finki.meetingscheduler.domain.valueobject;

import lombok.Getter;
import mk.ukim.finki.meetingscheduler.domain.exceptions.InvalidValueException;
import mk.ukim.finki.shared.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
@Getter
public class TimeSlot implements ValueObject {
    private Date startDateTime;
    private Date endDateTime;

    public TimeSlot(Date startDateTime, Date endDateTime) {
        if(startDateTime.after(endDateTime))
            throw new InvalidValueException();
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public TimeSlot() {
        this.startDateTime = new Date(System.currentTimeMillis());
        this.endDateTime = new Date(System.currentTimeMillis());
    }
}
