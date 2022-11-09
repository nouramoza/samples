package com.blu.bankservice.account.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCOUNT")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AccountEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER", nullable=false, unique = true)
    @NonNull
    private String accountNumber;

    @Column(name = "PERSON_ID", nullable=false)
    @NotNull
    private Long personId;

    @Column(name = "BALANCE", nullable=false)
    @NotNull
    private Long balance;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
