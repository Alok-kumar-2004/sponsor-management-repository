package com.example.sponsor_managment.services.impl;

import com.example.sponsor_managment.entity.SponsorEntity;
import com.example.sponsor_managment.repository.SponsorRepository;
import com.example.sponsor_managment.services.SponsorServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorServicesImpl implements SponsorServices {
    @Autowired
    private SponsorRepository sponsorRepository;

    private static final Logger logger= LoggerFactory.getLogger(SponsorServicesImpl.class);
    public List<SponsorEntity> getAllSponsors() {
        return sponsorRepository.findAll();
    }
    public SponsorEntity getSponsorById(Integer id) {
        logger.info("The logger type is info");
        logger.error("The logger type is error ");
        logger.warn("The logger type is warn");
        logger.debug("The logger type is debug");
        return sponsorRepository.findById(id).orElse(null);
    }
    public SponsorEntity saveSponsor(SponsorEntity sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public SponsorEntity updateSponsor(Integer id, SponsorEntity sponsor) {
//        SponsorEntity existingSponsor = sponsorRepository.findById(id).orElse(null);
//        if (existingSponsor != null) {
//            existingSponsor.setOrgName(sponsor.getOrgName());
//            existingSponsor.setOrgType(sponsor.getOrgType());
//            existingSponsor.setEmailId(sponsor.getEmailId());
//            existingSponsor.setAddress(sponsor.getAddress());
//            existingSponsor.setPhoneNo(sponsor.getPhoneNo());
//            existingSponsor.setSocialMedia(sponsor.getSocialMedia());
//            return sponsorRepository.save(existingSponsor);
//        }
        return sponsorRepository.findById(id).map(existingSponsor -> {
            existingSponsor.setOrgName(sponsor.getOrgName());
            existingSponsor.setOrgType(sponsor.getOrgType());
            existingSponsor.setEmailId(sponsor.getEmailId());
            existingSponsor.setAddress(sponsor.getAddress());
            existingSponsor.setPhoneNo(sponsor.getPhoneNo());
            existingSponsor.setSocialMedia(sponsor.getSocialMedia());
            return sponsorRepository.save(existingSponsor);
        }).orElse(null);
    }

    @Override
    public void deleteSponsor(Integer id) {
        sponsorRepository.deleteById(id);
    }

}
