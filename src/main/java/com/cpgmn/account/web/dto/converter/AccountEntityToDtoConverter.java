package com.cpgmn.account.web.dto.converter;

import com.cpgmn.account.entity.AccountEntity;
import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.entity.TransactionEntity;
import com.cpgmn.account.web.dto.AccountDto;
import com.cpgmn.account.web.dto.CreatedAccountDto;
import com.cpgmn.account.web.dto.CustomerDto;
import com.cpgmn.account.web.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountEntityToDtoConverter {

    public CreatedAccountDto convert(AccountEntity account) {
        return CreatedAccountDto.builder()
                .transactions(convertTransactions(account.getTransactions()))
                .id(account.getId())
                .balance(account.getBalance())
                .creationDate(account.getCreationDate())
                .customer(convertCustomer(account.getCustomer()))
                .build();
    }

    public Set<AccountDto> convert(List<AccountEntity> accounts) {
        return accounts.stream()
                .map(c -> AccountDto.builder()
                        .id(c.getId())
                        .balance(c.getBalance())
                        .creationDate(c.getCreationDate())
                        .transactions(convertTransactions(c.getTransactions()))
                        .build())
                .collect(Collectors.toSet());
    }

    private CustomerDto convertCustomer(CustomerEntity customerEntity) {
        return CustomerDto.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .surname(customerEntity.getSurname())
                .build();
    }

    private Set<TransactionDto> convertTransactions(Set<TransactionEntity> transactionEntities) {
        return transactionEntities.stream()
                .map(c -> TransactionDto.builder()
                        .id(c.getId())
                        .amount(c.getAmount())
                        .transactionDate(c.getTransactionDate())
                        .build())
                .collect(Collectors.toSet());
    }
}
