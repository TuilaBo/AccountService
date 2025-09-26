package com.khoavdse170395.accountservice.repository;

import com.khoavdse170395.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Optional<Account> findById(Long accountId);
}
