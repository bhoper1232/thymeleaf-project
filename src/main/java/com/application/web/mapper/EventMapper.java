package com.application.web.mapper;

import com.application.web.dto.EventDto;
import com.application.web.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .updatedOn(eventDto.getUpdatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .endTime(eventDto.getEndTime())
                .createdOn(eventDto.getCreatedOn())
                .type(eventDto.getType())
                .startTime(eventDto.getStartTime())
                .club(eventDto.getClub())
                .build();
    }

    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .updatedOn(event.getUpdatedOn())
                .photoUrl(event.getPhotoUrl())
                .endTime(event.getEndTime())
                .createdOn(event.getCreatedOn())
                .type(event.getType())
                .startTime(event.getStartTime())
                .club(event.getClub())
                .build();
    }

}
