package com.example.testapi.service;

import com.example.testapi.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccount(Long id);

    List<Account> getAllAccounts();

    void deleteAccountById(Long id);
}
