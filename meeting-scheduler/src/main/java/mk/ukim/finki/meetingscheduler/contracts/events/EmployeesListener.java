package mk.ukim.finki.meetingscheduler.contracts.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.service.MeetingService;
import mk.ukim.finki.shared.domain.config.Topics;
import mk.ukim.finki.shared.domain.events.DomainEvent;
import mk.ukim.finki.shared.domain.events.EmployeeAdded;
import mk.ukim.finki.shared.domain.events.EmployeeRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeesListener {

    private final MeetingService meetingService;

    @KafkaListener(topics = Topics.EMPLOYEE_ADDED)
    public void employeeAdded(String jsonEvent) {
        try {
            EmployeeAdded event = DomainEvent.fromJson(jsonEvent, EmployeeAdded.class);
            meetingService.employeeAdded(event.getEmployeeId(), event.getName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = Topics.EMPLOYEE_REMOVED)
    public void employeeRemoved(String jsonEvent) {
        try {
            EmployeeRemoved event = DomainEvent.fromJson(jsonEvent, EmployeeRemoved.class);
            meetingService.employeeRemoved(event.getEmployeeId());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
