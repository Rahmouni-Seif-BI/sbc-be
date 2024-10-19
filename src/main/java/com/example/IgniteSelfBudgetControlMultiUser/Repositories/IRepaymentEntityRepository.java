package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepaymentEntityRepository extends JpaRepository<RepaymentEntity,Long> {

    public List<RepaymentEntity> findRepaymentEntityByUser_Id(Long userId);
    public RepaymentEntity  getRepaymentEntityByIdAndUserId(Long repaymentEntityId, Long userId);
}
