package com.cpgmn.account.service;

import com.cpgmn.account.common.DateTimeUtils;
import com.cpgmn.account.entity.AccountEntity;
import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.entity.TransactionEntity;
import com.cpgmn.account.repository.AccountRepository;
import com.cpgmn.account.web.dto.AccountDto;
import com.cpgmn.account.web.dto.CreateAccountRequest;
import com.cpgmn.account.web.dto.CreatedAccountDto;
import com.cpgmn.account.web.dto.converter.AccountEntityToDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final CustomerService customerService;
    private final AccountEntityToDtoConverter converter;

    public CreatedAccountDto createAccount(CreateAccountRequest request) {
        CustomerEntity customer = customerService.getByIdOrThrow(request.getCustomerId());

        AccountEntity account = AccountEntity.builder()
                .customer(customer)
                .creationDate(DateTimeUtils.getLocalDateTimeNow())
                .balance(request.getInitialCredit())
                .build();

        if (request.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            TransactionEntity transaction = TransactionEntity.builder()
                    .account(account)
                    .transactionDate(DateTimeUtils.getLocalDateTimeNow())
                    .amount(request.getInitialCredit())
                    .build();
            account.getTransactions().add(transaction);
        }
        repository.save(account);
        return converter.convert(account);
    }

    public Set<AccountDto> getAccountsByCustomerId(UUID customerId) {
        List<AccountEntity> accounts = repository.findAllByCustomerId(customerId);
       return converter.convert(accounts);
    }
}
