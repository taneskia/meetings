import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { MeetingDto } from '../models/meetingDto';
import { Person } from '../models/person';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {
  private roomsApiUrl = environment.rooms_api;
  private peopleApiUrl = environment.people_api;
  private meetingApiUrl = environment.meeting_api;

  constructor(private http: HttpClient) { }

  getRooms(): Observable<Array<Room>> {
    return this.http.get<Array<Room>>(this.roomsApiUrl);
  }

  getRoom(roomId: string) {
    return this.http.get<Room>(this.roomsApiUrl + "/" + roomId);
  }

  getPeople() {
    return this.http.get<Person[]>(this.peopleApiUrl);
  }

  createMeeting(meetingDto: MeetingDto) {
    this.http.post<MeetingDto>(this.meetingApiUrl, meetingDto).subscribe();
  }
}
