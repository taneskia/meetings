import { Route } from '@angular/compiler/src/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTable } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Person } from 'src/app/models/person';
import { Room } from 'src/app/models/room';
import { RoomsService } from 'src/app/services/rooms.service';
import { DialogComponent } from '../dialog/dialog.component';
import { NewMeetingComponent } from '../new-meeting/new-meeting.component';

export interface Row {
  participants: Person[];
  start: Date;
  end: Date;
}

@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styles: [`
    table {
      width: 100%;
    }
    button {
      margin-bottom: 10px;
    }
  `]
})
export class RoomDetailsComponent implements OnInit {

  @ViewChild(MatTable) table!: MatTable<any>;

  room!: Room;
  displayedColumns: string[] = ['start', 'end', 'participants'];
  dataSource: Row[] = [];

  constructor(
    private roomService: RoomsService,
    private route: ActivatedRoute,
    public dialog: MatDialog) { }

  ngOnInit(): void {
    var roomId = this.route.snapshot.params["id"]
    this.roomService.getRoom(roomId).subscribe(
      (room) => {
        this.room = room;
        room.meetings.forEach(meeting => {
          this.dataSource.push({ participants: meeting.personList, start: new Date(meeting.timeSlot.startDateTime), end: new Date(meeting.timeSlot.endDateTime) });
          this.table.renderRows();
        });
      }
    )
  }

  showParticipants(participants: Person[]) {
    this.dialog.open(DialogComponent, {
      data: participants
    });
  }

  addMeeting() {
    this.dialog.open(NewMeetingComponent, {
      data: this.room.id.id
    });
  }
}
