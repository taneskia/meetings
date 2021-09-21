import { ID } from "./id";
import { Meeting } from "./meeting";

export interface Room {
    id: ID;
    number: number;
    capacity: number;
    meetings: Array<Meeting>;
}