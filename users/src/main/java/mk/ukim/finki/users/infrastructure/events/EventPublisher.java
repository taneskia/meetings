package mk.ukim.finki.users.infrastructure.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.shared.domain.events.DomainEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.getTopic(), event.toJson());
    }

}
