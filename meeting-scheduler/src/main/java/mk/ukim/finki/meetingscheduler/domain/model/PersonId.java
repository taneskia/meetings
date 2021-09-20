package mk.ukim.finki.meetingscheduler.domain.model;

import mk.ukim.finki.shared.domain.model.BaseId;

public class PersonId extends BaseId {

    protected PersonId() {
        super(PersonId.randomId(PersonId.class).getId());
    }

    public PersonId(String uid) {
        super(uid);
    }
}
