package com.blu.bankservice.account.repository;

import com.blu.bankservice.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    AccountEntity findByAccountNumber(String accountNumber);
}
