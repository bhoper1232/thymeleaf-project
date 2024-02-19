package com.application.web.service;

import com.application.web.dto.EventDto;
import com.application.web.models.Event;

import java.util.List;

public interface EventService {

    void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto findByEventId(Long eventId);
}
