package com.example.sponsor_managment.controller;


import com.example.sponsor_managment.services.SponsorServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sponsor_managment.entity.SponsorEntity;
import com.example.sponsor_managment.services.SponsorServices;

import java.util.List;

@RestController
@RequestMapping("/api/sponsors")
@Tag(name = "Sponsor Entity",description = "Create,Read,Update,Delete The Sponsor ")
public class SponsorController {
    @Autowired
    private SponsorServices SponsorServices;

    @GetMapping
    public List<SponsorEntity> getAllSponsors() {
        return SponsorServices.getAllSponsors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SponsorEntity> getSponsorById(@PathVariable Integer id) {
        SponsorEntity sponsor = SponsorServices.getSponsorById(id);
        if (sponsor != null) {
            return new ResponseEntity<>(sponsor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public SponsorEntity createSponsor(@RequestBody SponsorEntity sponsor) {
        return SponsorServices.saveSponsor(sponsor);
    }
     @PutMapping("/{id}")
   public ResponseEntity<SponsorEntity> updateSponsor(@PathVariable Integer id, @RequestBody SponsorEntity sponsor) {
         SponsorEntity updatedSponsor = SponsorServices.updateSponsor(id, sponsor);
         if (updatedSponsor != null) {
             return new ResponseEntity<>(updatedSponsor, HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Integer id) {
        SponsorServices.deleteSponsor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}