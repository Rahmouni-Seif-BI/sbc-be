package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISpendingRepository extends JpaRepository<Spending,Long> {
    public Spending getSpendingsByIdAndUserId(Long spendingId, Long userId);
    public List<Spending> getSpendingsByUser_Id(Long userId);
    public List<Spending> getSpendingByAccount_IdAndUserId(Long accountId, Long userId);
}
