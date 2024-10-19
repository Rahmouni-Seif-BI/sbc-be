package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Account;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICreditEntityRepository extends JpaRepository<CreditEntity,Long> {

    public List<CreditEntity> findCreditEntityByUser_Id(Long userId);
    public CreditEntity  getCreditEntityByIdAndUserId(Long creditEntityId, Long userId);
}
