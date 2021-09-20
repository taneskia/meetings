package mk.ukim.finki.meetingscheduler.domain.controller;

import mk.ukim.finki.meetingscheduler.domain.dtos.MeetingDto;
import mk.ukim.finki.meetingscheduler.domain.model.Meeting;
import mk.ukim.finki.meetingscheduler.domain.service.MeetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@CrossOrigin(origins = "*")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("")
    public List<Meeting> getMeetings() {
        return meetingService.getMeetings();
    }

    @PostMapping("")
    public Meeting createMeeting(@RequestBody MeetingDto meetingDto) {
        return this.meetingService.createNewMeeting(meetingDto);
    }
}
