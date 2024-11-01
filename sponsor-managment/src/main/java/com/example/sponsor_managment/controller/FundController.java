package com.example.sponsor_managment.controller;

import com.example.sponsor_managment.entity.FundEntity;
import com.example.sponsor_managment.services.FundServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/funds")
@Tag(name = "Funds Entity",description = "Create,Read,Update,Delete The Funds ")
public class FundController {

    @Autowired
    private FundServices fundService;

    @GetMapping
    public List<FundEntity> getAllFunds() {
        return fundService.getAllFunds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundEntity> getFundById(@PathVariable Long id) {
        return ResponseEntity.ok(fundService.getFundById(id));
    }

    @PostMapping
    public ResponseEntity<FundEntity> createFund(@RequestBody FundEntity fund) {
        return ResponseEntity.ok(fundService.createFund(fund));
    }
    @PutMapping("/{id}")
    public ResponseEntity<FundEntity> updateFund(@PathVariable Long id, @RequestBody FundEntity fund) {
        return ResponseEntity.ok(fundService.updateFund(id, fund));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFund(@PathVariable Long id) {
        fundService.deleteFund(id);
        return ResponseEntity.noContent().build();
    }
}
