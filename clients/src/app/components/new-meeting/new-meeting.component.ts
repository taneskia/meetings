import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Person } from 'src/app/models/person';
import { RoomsService } from 'src/app/services/rooms.service';
import { MeetingDto } from '../../models/meetingDto';
import { PersonDto } from '../../models/personDto';

@Component({
  selector: 'app-new-meeting',
  templateUrl: './new-meeting.component.html',
  styleUrls: ['./new-meeting.component.css']
})
export class NewMeetingComponent implements OnInit {

  people = new FormControl();

  startDateControl = new FormControl(new Date());

  endDateControl = new FormControl(new Date());

  peopleList: Person[] = [];

  constructor(@Inject(MAT_DIALOG_DATA) public roomId: string, private roomsService: RoomsService) { }

  ngOnInit(): void {
    this.roomsService.getPeople().subscribe(
      (peopleList) => this.peopleList = peopleList
    )
  }

  addMeeting() {
    let personDtos: PersonDto[] = [];

    this.people.value.forEach((p: Person) => {
      personDtos.push({
        personId: p.id.id,
        name: p.name
      })
    });

    let meetingDto: MeetingDto = {
      roomId: this.roomId,
      startDate: this.startDateControl.value,
      endDate: this.endDateControl.value,
      personDtoList: personDtos
    }

    this.roomsService.createMeeting(meetingDto);
  }
}
