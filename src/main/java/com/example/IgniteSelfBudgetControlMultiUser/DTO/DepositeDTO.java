package com.example.IgniteSelfBudgetControlMultiUser.DTO;
import java.util.Date;

public class DepositeDTO {
    private Long id;
    private String code;
    private float amountToDeposite;
    private Date actionDate;
    private String notes;
    private Long accountId;
    private String accountCode;
    private String accountDescription;

    public DepositeDTO() {
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

    public float getAmountToDeposite() {
        return amountToDeposite;
    }

    public void setAmountToDeposite(float amountToDeposite) {
        this.amountToDeposite = amountToDeposite;
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
