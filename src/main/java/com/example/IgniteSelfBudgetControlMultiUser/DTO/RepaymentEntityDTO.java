package com.example.IgniteSelfBudgetControlMultiUser.DTO;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class RepaymentEntityDTO {

    private Long id;
    private double amountRepaid;
    private LocalDate repaymentDate;
    private Long creditorAccountId;
    private String creditorAccountCode;
    private String creditorAccountDescription;

    private Long debtorAccountId;
    private String debtorAccountCode;
    private String debtorAccountDescription;

    public RepaymentEntityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmountRepaid() {
        return amountRepaid;
    }

    public void setAmountRepaid(double amountRepaid) {
        this.amountRepaid = amountRepaid;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
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
        return "RepaymentEntityDTO{" +
                "id=" + id +
                ", amountRepaid=" + amountRepaid +
                ", repaymentDate=" + repaymentDate +
                ", creditorAccountId=" + creditorAccountId +
                ", creditorAccountCode='" + creditorAccountCode + '\'' +
                ", creditorAccountDescription='" + creditorAccountDescription + '\'' +
                ", debtorAccountId=" + debtorAccountId +
                ", debtorAccountCode='" + debtorAccountCode + '\'' +
                ", debtorAccountDescription='" + debtorAccountDescription + '\'' +
                '}';
    }
}
