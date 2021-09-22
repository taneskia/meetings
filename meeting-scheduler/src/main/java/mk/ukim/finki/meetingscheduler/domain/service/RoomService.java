package mk.ukim.finki.meetingscheduler.domain.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.exceptions.NotFoundException;
import mk.ukim.finki.meetingscheduler.domain.model.Room;
import mk.ukim.finki.meetingscheduler.domain.model.RoomId;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.PersonRepository;
import mk.ukim.finki.meetingscheduler.infrastructure.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final MeetingService meetingService;
    private final PersonRepository personRepository;

    public List<Room> getRooms() {
        return this.roomRepository.findAll();
    }

    public Room getRoom(String roomId) {
        return this.roomRepository.findById(new RoomId(roomId)).orElseThrow(() -> {
            throw new NotFoundException();
        } );
    }
}
