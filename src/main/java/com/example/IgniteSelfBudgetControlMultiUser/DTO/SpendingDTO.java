package com.example.IgniteSelfBudgetControlMultiUser.DTO;

import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class SpendingDTO {
    private Long id;
    private String code;
    private float amountToSpend;
    private Date actionDate;
    private String notes;

    private Long purposeId;
    private String purposeCode;
    private String purposeDescription;

    private Long creditStatusId;
    private String creditStatusCode;
    private String creditStatusDescription;

    private Long accountId;
    private String accountCode;
    private String accountDescription;

    public SpendingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getAmountToSpend() {
        return amountToSpend;
    }

    public void setAmountToSpend(float amountToSpend) {
        this.amountToSpend = amountToSpend;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(Long purposeId) {
        this.purposeId = purposeId;
    }

    public String getPurposeCode() {
        return purposeCode;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public String getPurposeDescription() {
        return purposeDescription;
    }

    public void setPurposeDescription(String purposeDescription) {
        this.purposeDescription = purposeDescription;
    }
    public Long getCreditStatusId() {
        return creditStatusId;
    }

    public void setCreditStatusId(Long creditStatusId) {
        this.creditStatusId = creditStatusId;
    }

    public String getCreditStatusCode() {
        return creditStatusCode;
    }

    public void setCreditStatusCode(String creditStatusCode) {
        this.creditStatusCode = creditStatusCode;
    }

    public String getCreditStatusDescription() {
        return creditStatusDescription;
    }

    public void setCreditStatusDescription(String creditStatusDescription) {
        this.creditStatusDescription = creditStatusDescription;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }
}
