package com.khoavdse170395.accountservice.service.AccountService;

import com.khoavdse170395.accountservice.model.Account;
import com.khoavdse170395.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FeignClient(name = "account-service", url = "http://localhost:8081")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account addAccount(Account account) {
        if (accountRepository.findByUsername(account.getUsername()) != null) {
            throw new RuntimeException("Username already exists!");
        }
        return accountRepository.save(account);
    }


    @Override
    public Optional<Account> getAccountById(long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public void deleteAccount(long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found");
        } else {
            accountRepository.deleteById(accountId);
        }


    }

    @Override
    public Account updateAccount(long id,Account account) {
        if(!accountRepository.existsById(account.getId()) ){
            throw new RuntimeException("Account not found");
        } else {
            return accountRepository.save(account);
        }
    }
}