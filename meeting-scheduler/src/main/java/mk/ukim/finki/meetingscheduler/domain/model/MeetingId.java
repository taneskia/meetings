package mk.ukim.finki.meetingscheduler.domain.model;

import mk.ukim.finki.shared.domain.model.BaseId;

import javax.persistence.Embeddable;

@Embeddable
public class MeetingId extends BaseId {

    protected MeetingId() {
        super(MeetingId.randomId(MeetingId.class).getId());
    }

    public MeetingId(String uid) {
        super(uid);
    }
}
