package com.example.IgniteSelfBudgetControlMultiUser.Repositories;


import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurposeRepository extends JpaRepository<Purpose,Long> {


    public List<Purpose> findPurposeByUser_Id(Long userId);
    public Purpose  getPurposeByIdAndUserId(Long purposeId, Long userId);
}
