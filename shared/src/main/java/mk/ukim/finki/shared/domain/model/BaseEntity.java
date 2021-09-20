package mk.ukim.finki.shared.domain.model;

import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@MappedSuperclass
public class BaseEntity<ID extends BaseId> {
    @EmbeddedId
    private ID id;

    protected BaseEntity() {
    }

    protected BaseEntity(@NonNull ID id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        var other = (BaseEntity<?>) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), id);
    }
}
