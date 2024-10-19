package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICreditStatusRepository extends JpaRepository<CreditStatus,Long> {
    public List<CreditStatus> findCreditStatusByUser_Id(Long userId);
    public CreditStatus  getCreditStatusByIdAndUserId(Long creditEntityId, Long userId);
}
