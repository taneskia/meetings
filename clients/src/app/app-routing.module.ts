import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeesComponent } from './components/employees/employees.component';
import { NewMeetingComponent } from './components/new-meeting/new-meeting.component';
import { RoomDetailsComponent } from './components/room-details/room-details.component';
import { RoomsComponent } from './components/rooms/rooms.component';

const routes: Routes = [
  { path: 'rooms', component: RoomsComponent },
  { path: 'rooms/:id', component: RoomDetailsComponent },
  { path: 'employees', component: EmployeesComponent },
  { path: '**', redirectTo: "rooms" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
