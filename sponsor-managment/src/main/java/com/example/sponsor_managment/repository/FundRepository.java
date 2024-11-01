package com.example.sponsor_managment.repository;

import com.example.sponsor_managment.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  FundRepository extends JpaRepository<FundEntity,Long> {
}
