import { ID } from "./id";
import { Person } from "./person";
import { TimeSlot } from "./time-slot";

export interface Meeting {
    id: ID;
    timeSlot: TimeSlot;
    personList: Array<Person>;
}