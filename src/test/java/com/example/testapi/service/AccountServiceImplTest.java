package com.example.testapi.service;

import com.example.testapi.TestApiApplication;
import com.example.testapi.model.Account;
import com.example.testapi.model.User;
import com.example.testapi.repository.AccountRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


class AccountServiceImplTest extends TestApiApplication {

    private final AccountRepository accountRepository = Mockito.mock(AccountRepository.class);

    private final Account account = Mockito.mock(Account.class);
    private final User user = Mockito.mock(User.class);

    private final  AccountServiceImpl accountService = new AccountServiceImpl(accountRepository);

    @Before
    public void init() {
        initAccount();
        initUser();
    }

    @Test
    public void createAccountTest() {
        Mockito.when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account actualAccount = accountService.createAccount(account);

        verify(accountRepository, times(1)).save(account);
        assertEquals(account, actualAccount);
    }

    @Test
    public void getAccountTest() {
        Mockito.when(accountRepository.getAccountById(any())).thenReturn(Optional.of(account));

        Account actualAccount = accountService.getAccount(1L);

        assertEquals(account, actualAccount);
    }

    public void initAccount() {
        account.setId(1l);
        account.setBalance(1000l);
        account.setAccountNum(12345678L);
        account.setAccountType("card");
        account.setBalance(10000L);
        account.setUser(user);

    }

    public void initUser() {
        user.setId(1l);
        user.setFirstName("Max");
        user.setSecondName("Maxov");
    }
}