package com.application.web.service.impl;

import com.application.web.dto.EventDto;
import com.application.web.mapper.EventMapper;
import com.application.web.models.Club;
import com.application.web.models.Event;
import com.application.web.repository.ClubRepository;
import com.application.web.repository.EventRepository;
import com.application.web.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.application.web.mapper.EventMapper.mapToEvent;
import static com.application.web.mapper.EventMapper.mapToEventDto;

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

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();

        return events.stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }
}
