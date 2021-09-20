package mk.ukim.finki.meetingscheduler.infrastructure.repository;

import mk.ukim.finki.meetingscheduler.domain.model.Room;
import mk.ukim.finki.meetingscheduler.domain.model.RoomId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, RoomId> {
}