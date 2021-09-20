package mk.ukim.finki.users.domain.model;

import mk.ukim.finki.shared.domain.model.BaseId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeId extends BaseId {

    protected EmployeeId() {
        super(EmployeeId.randomId(EmployeeId.class).getId());
    }

    public EmployeeId(String uid) {
        super(uid);
    }
}
