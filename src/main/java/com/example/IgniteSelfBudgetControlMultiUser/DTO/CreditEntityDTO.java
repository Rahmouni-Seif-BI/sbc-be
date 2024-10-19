package com.example.IgniteSelfBudgetControlMultiUser.DTO;

import java.time.LocalDate;

public class CreditEntityDTO {
    private Long id;
    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endDate;

    private Long creditorAccountId;
    private String creditorAccountCode;
    private String creditorAccountDescription;

    private Long debtorAccountId;
    private String debtorAccountCode;
    private String debtorAccountDescription;

    public CreditEntityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getCreditorAccountId() {
        return creditorAccountId;
    }

    public void setCreditorAccountId(Long creditorAccountId) {
        this.creditorAccountId = creditorAccountId;
    }

    public String getCreditorAccountCode() {
        return creditorAccountCode;
    }

    public void setCreditorAccountCode(String creditorAccountCode) {
        this.creditorAccountCode = creditorAccountCode;
    }

    public String getCreditorAccountDescription() {
        return creditorAccountDescription;
    }

    public void setCreditorAccountDescription(String creditorAccountDescription) {
        this.creditorAccountDescription = creditorAccountDescription;
    }

    public Long getDebtorAccountId() {
        return debtorAccountId;
    }

    public void setDebtorAccountId(Long debtorAccountId) {
        this.debtorAccountId = debtorAccountId;
    }

    public String getDebtorAccountCode() {
        return debtorAccountCode;
    }

    public void setDebtorAccountCode(String debtorAccountCode) {
        this.debtorAccountCode = debtorAccountCode;
    }

    public String getDebtorAccountDescription() {
        return debtorAccountDescription;
    }

    public void setDebtorAccountDescription(String debtorAccountDescription) {
        this.debtorAccountDescription = debtorAccountDescription;
    }

    @Override
    public String toString() {
        return "CreditEntityDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", creditorAccountId=" + creditorAccountId +
                ", creditorAccountCode='" + creditorAccountCode + '\'' +
                ", creditorAccountDescription='" + creditorAccountDescription + '\'' +
                ", debtorAccountId=" + debtorAccountId +
                ", debtorAccountCode='" + debtorAccountCode + '\'' +
                ", debtorAccountDescription='" + debtorAccountDescription + '\'' +
                '}';
    }
}


