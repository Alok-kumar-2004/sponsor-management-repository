package com.example.sponsor_managment.services;

import com.example.sponsor_managment.entity.FundEntity;

import java.util.List;

public interface FundServices {
    List<FundEntity> getAllFunds();
    FundEntity getFundById(Long id);
    FundEntity createFund(FundEntity fund);
    FundEntity updateFund(Long id, FundEntity fund);
    void deleteFund(Long id);
}
