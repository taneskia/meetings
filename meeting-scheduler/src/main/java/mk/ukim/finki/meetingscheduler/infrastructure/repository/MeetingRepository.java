package mk.ukim.finki.meetingscheduler.infrastructure.repository;

import mk.ukim.finki.meetingscheduler.domain.model.Meeting;
import mk.ukim.finki.meetingscheduler.domain.model.MeetingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, MeetingId> {
}
