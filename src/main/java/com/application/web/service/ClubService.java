package com.application.web.service;

import com.application.web.dto.ClubDto;
import com.application.web.models.Club;

import java.util.List;

public interface ClubService {

    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long id);

    void updateClub(ClubDto club);

    void delete(long clubId);

    List<ClubDto> searchClubs(String query);
}
