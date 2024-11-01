package com.example.sponsor_managment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sponsor_managment.entity.SponsorEntity;
public interface SponsorRepository extends JpaRepository<SponsorEntity,Integer>{

}
