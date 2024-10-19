package com.example.IgniteSelfBudgetControlMultiUser.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class RepaymentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account creditorAccount;

    @ManyToOne
    private Account debtorAccount;

    private double amountRepaid;

    private LocalDate repaymentDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

}
