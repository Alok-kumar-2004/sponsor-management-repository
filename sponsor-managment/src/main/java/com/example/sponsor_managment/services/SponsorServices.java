package com.example.sponsor_managment.services;

import com.example.sponsor_managment.entity.SponsorEntity;

import java.util.List;

public interface SponsorServices  {
    public List<SponsorEntity> getAllSponsors();
    SponsorEntity getSponsorById(Integer id);
    SponsorEntity  saveSponsor(SponsorEntity  sponsor);
    SponsorEntity  updateSponsor(Integer id, SponsorEntity  sponsor);
    void deleteSponsor(Integer id);
}
