package com.application.web.service;

import com.application.web.dto.EventDto;

public interface EventService {

    void createEvent(Long clubId, EventDto eventDto);

}
