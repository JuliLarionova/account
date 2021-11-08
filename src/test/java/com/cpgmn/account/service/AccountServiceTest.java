package com.cpgmn.account.service;

import com.cpgmn.account.BaseIT;
import com.cpgmn.account.common.ClientException;
import com.cpgmn.account.entity.AccountEntity;
import com.cpgmn.account.repository.AccountRepository;
import com.cpgmn.account.web.dto.AccountDto;
import com.cpgmn.account.web.dto.CreateAccountRequest;
import com.cpgmn.account.web.dto.CreatedAccountDto;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static com.cpgmn.account.service.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountServiceTest extends BaseIT {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void createsAccount() {
        //given
        CreateAccountRequest request = getCreateAccountRequest();
        CreatedAccountDto expectedAccount = getCreatedAccountDto();
        //when
        CreatedAccountDto createdAccount = accountService.createAccount(request);
        //then
        Assertions.assertThat(createdAccount)
                .usingRecursiveComparison(RecursiveComparisonConfiguration.builder()
                        .withIgnoredFields("id", "creationDate")
                        .build())
                .isEqualTo(expectedAccount);
        Assertions.assertThat(createdAccount.getTransactions()).isEmpty();
    }

    @Test
    void createsAccountAndTransaction() {
        //given
        CreateAccountRequest request = getCreateAccountRequest().toBuilder()
                .initialCredit(BigDecimal.TEN)
                .build();
        CreatedAccountDto expectedAccount = getCreatedAccountDto().toBuilder()
                .balance(BigDecimal.TEN)
                .build();
        //when
        CreatedAccountDto createdAccount = accountService.createAccount(request);
        //then
        Assertions.assertThat(createdAccount)
                .usingRecursiveComparison(RecursiveComparisonConfiguration.builder()
                        .withIgnoredFields("id", "creationDate", "transactions")
                        .build())
                .isEqualTo(expectedAccount);
        Assertions.assertThat(createdAccount.getTransactions()).hasSize(1);
    }

    @Test
    void throwsClientException_whenCustomerNotFound() {
        //given
        CreateAccountRequest request = getCreateAccountRequest().toBuilder()
                .customerId(UUID.randomUUID())
                .build();
        //when
        assertThrows(ClientException.class, ()-> accountService.createAccount(request));
    }

    @Test
    void getsAccountsByCustomerId() {
        //given
        createAccount(getAccountEntity());
        var expectedAccount = getAccountDto();
        //when
        Set<AccountDto> accounts = accountService.getAccountsByCustomerId(CUSTOMER_ID);
        //then
        assertEquals(accounts, Set.of(expectedAccount));
    }

    private void createAccount(AccountEntity accountEntity) {
        accountRepository.saveAndFlush(accountEntity);
    }
}