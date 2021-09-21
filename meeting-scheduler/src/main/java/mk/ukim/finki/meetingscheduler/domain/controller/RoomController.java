package mk.ukim.finki.meetingscheduler.domain.controller;

import lombok.AllArgsConstructor;
import mk.ukim.finki.meetingscheduler.domain.model.Room;
import mk.ukim.finki.meetingscheduler.domain.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("")
    public List<Room> getRooms() {
        return this.roomService.getRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable String id) {
        return this.roomService.getRoom(id);
    }
}
