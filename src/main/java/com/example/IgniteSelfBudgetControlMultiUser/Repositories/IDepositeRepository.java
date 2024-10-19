package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Spending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepositeRepository extends JpaRepository<Deposite,Long> {
    List<Deposite> getDepositeByAccount_Id(Long accountId);

    public List<Deposite> findDepositeByUser_Id(Long userId);
    public Deposite  getDepositeByIdAndUserId(Long depositeId, Long userId);

    public List<Deposite> getDepositeByAccount_IdAndUserId(Long accountId, Long userId);

}
