package mk.ukim.finki.meetingscheduler.domain.model;

import mk.ukim.finki.shared.domain.model.BaseId;

import javax.persistence.Embeddable;

@Embeddable
public class RoomId extends BaseId {

    protected RoomId() {
        super(RoomId.randomId(RoomId.class).getId());
    }

    public RoomId(String uid) {
        super(uid);
    }
}
