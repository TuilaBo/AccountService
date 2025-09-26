package com.khoavdse170395.accountservice.service.AccountService;

import com.khoavdse170395.accountservice.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {
    List<Account> getAllAccounts();
    Account addAccount(Account account);
    Optional<Account> getAccountById(long accountId);
    void deleteAccount(long accountId);
    Account updateAccount(long id,Account account);
}
