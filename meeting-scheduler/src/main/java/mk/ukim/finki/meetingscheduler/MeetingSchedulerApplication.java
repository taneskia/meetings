package mk.ukim.finki.meetingscheduler;

import mk.ukim.finki.meetingscheduler.infrastructure.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeetingSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingSchedulerApplication.class, args);
    }

}
