import { PersonDto } from "./personDto";

export interface MeetingDto {
    roomId: string;
    startDate: Date;
    endDate: Date;
    personDtoList: PersonDto[];
}