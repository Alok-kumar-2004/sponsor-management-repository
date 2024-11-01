package com.example.sponsor_managment.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funds")
@Data
public class FundEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;
    private BigDecimal amount;
    private String purpose;
    private LocalDate dateReceived;
    private Long eventId;

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    public void setSponsor(SponsorEntity sponsor) {
        this.sponsor = sponsor;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getFundId() {
        return fundId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public SponsorEntity getSponsor() {
        return sponsor;
    }

    public Long getEventId() {
        return eventId;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sponsor_id", referencedColumnName = "sponsorId", nullable = false)
    private SponsorEntity sponsor;


}
