import { Component, OnInit } from '@angular/core';
import { Room } from 'src/app/models/room';
import { RoomsService } from 'src/app/services/rooms.service';

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styles: [`
    .mat-list-icon {
      color: rgba(0, 0, 0, 0.54);
    }
  `]
})
export class RoomsComponent implements OnInit {

  rooms!: Array<Room>;

  constructor(private roomService: RoomsService) { }

  ngOnInit(): void {
    this.roomService.getRooms().subscribe(
      (rooms) => {this.rooms = rooms},
      (error) => {console.log(error)}
    )
  }

}
