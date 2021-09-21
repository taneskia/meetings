package mk.ukim.finki.shared.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Getter
@MappedSuperclass
public class BaseId implements Serializable {

    private String id;

    @JsonCreator
    protected BaseId(@NonNull String uuid) {
        this.id = Objects.requireNonNull(uuid);
    }

    protected BaseId() {
    }

    @NonNull
    public static <ID extends BaseId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "idClass must not be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        } catch (Exception ex) {
            throw new RuntimeException("Could not create new instance of " + idClass, ex);
        }
    }
}
