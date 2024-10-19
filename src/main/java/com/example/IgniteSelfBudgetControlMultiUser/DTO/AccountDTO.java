package com.example.IgniteSelfBudgetControlMultiUser.DTO;


import java.util.List;

public class AccountDTO {
    private Long id;
    private String code;
    private String description;
    private String owner;
    private double amountBalance;
    private double amountConsumed;
    private double amountRest;

    public List<SpendingDTO> spendingDTOList;
    public List<DepositeDTO> depositeDTOList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(double amountBalance) {
        this.amountBalance = amountBalance;
    }

    public double getAmountConsumed() {
        return amountConsumed;
    }

    public void setAmountConsumed(double amountConsumed) {
        this.amountConsumed = amountConsumed;
    }

    public double getAmountRest() {
        return amountRest;
    }

    public void setAmountRest(double amountRest) {
        this.amountRest = amountRest;
    }

    public List<SpendingDTO> getSpendingDTOList() {
        return spendingDTOList;
    }

    public void setSpendingDTOList(List<SpendingDTO> spendingDTOList) {
        this.spendingDTOList = spendingDTOList;
    }

    public List<DepositeDTO> getDepositeDTOList() {
        return depositeDTOList;
    }

    public void setDepositeDTOList(List<DepositeDTO> depositeDTOList) {
        this.depositeDTOList = depositeDTOList;
    }
}
