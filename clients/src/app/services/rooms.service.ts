import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Room } from '../models/room';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {
  private roomsApiUrl = environment.rooms_api;

  constructor(private http: HttpClient) { }

  getRooms(): Observable<Array<Room>> {
    return this.http.get<Array<Room>>(this.roomsApiUrl);
  }

  getRoom(roomId: string) {
    return this.http.get<Room>(this.roomsApiUrl + "/" + roomId);
  }
}
