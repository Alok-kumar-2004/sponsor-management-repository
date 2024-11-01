package com.example.sponsor_managment.services.impl;

import com.example.sponsor_managment.entity.FundEntity;
import com.example.sponsor_managment.exception.ResourceNotFoundException;
import com.example.sponsor_managment.repository.FundRepository;
import com.example.sponsor_managment.services.FundServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FundServicesImpl implements FundServices {

    @Autowired
    private FundRepository fundRepository;
    private static final Logger logger= LoggerFactory.getLogger(FundServicesImpl.class);
    public List<FundEntity>getAllFunds(){
        return fundRepository.findAll();
    }
    public FundEntity getFundById(Long id) {
        FundEntity fund=fundRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fund not found with id: " + id));
        logger.info("The logger is implemented: {} is the amount by fund ID {}", fund.getAmount(), fund.getFundId());
        logger.debug("The debug logger is implemented: {} is the amount by fund ID {}", fund.getAmount(), fund.getFundId());
        logger.warn("The warn logger is implemented: {} is the amount by fund ID {}", fund.getAmount(), fund.getFundId());

        return fund;
    }

    public FundEntity createFund(FundEntity fund) {
        return fundRepository.save(fund);
    }
    public FundEntity updateFund(Long id, FundEntity fund) {
        FundEntity existingFund = getFundById(id);
        existingFund.setAmount(fund.getAmount());
        existingFund.setPurpose(fund.getPurpose());
        existingFund.setDateReceived(fund.getDateReceived());
        existingFund.setSponsor(fund.getSponsor());
        existingFund.setEventId(fund.getEventId());
        return fundRepository.save(existingFund);
    }

    public void deleteFund(Long id) {
        FundEntity fund = getFundById(id);
        fundRepository.delete(fund);
    }
}
