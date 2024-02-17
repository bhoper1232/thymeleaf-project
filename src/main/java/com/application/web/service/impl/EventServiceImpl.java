package com.application.web.service.impl;

import com.application.web.dto.EventDto;
import com.application.web.models.Club;
import com.application.web.models.Event;
import com.application.web.repository.ClubRepository;
import com.application.web.repository.EventRepository;
import com.application.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();

        Event event = mapToEvent(eventDto);

        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .updatedOn(eventDto.getUpdatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .endTime(eventDto.getEndTime())
                .createdOn(eventDto.getCreatedOn())
                .type(eventDto.getType())
                .startTime(eventDto.getStartTime())
                .build();
    }
}
