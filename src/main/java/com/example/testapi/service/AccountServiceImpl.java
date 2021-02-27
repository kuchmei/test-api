package com.example.testapi.service;

import com.example.testapi.exception.AccountNotFoundException;
import com.example.testapi.model.Account;
import com.example.testapi.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.getAccountById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not exist"));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.delete(getAccount(id));
    }
}
