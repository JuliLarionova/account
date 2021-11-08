package com.cpgmn.account.service;

import com.cpgmn.account.entity.AccountEntity;
import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.web.dto.AccountDto;
import com.cpgmn.account.web.dto.CreateAccountRequest;
import com.cpgmn.account.web.dto.CreatedAccountDto;
import com.cpgmn.account.web.dto.CustomerDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.UUID;

import static java.util.UUID.fromString;

public class TestDataFactory {
    public static final UUID CUSTOMER_ID = fromString("a7e7ba88-35b9-11ec-bd22-bb29106ca7af");
    public static final UUID ACCOUNT_ID = fromString("a7e85682-35b9-11ec-bd23-df2635677886");
    public static final Instant CREATION_DATE_INSTANT = Instant.parse("2021-11-06T10:15:30.00Z");
    public static final LocalDateTime ACCOUNT_CREATION_DATE = LocalDateTime.ofInstant(CREATION_DATE_INSTANT, ZoneOffset.UTC);
    public static final String CUSTOMER_NAME = "Mikhail";
    public static final String CUSTOMER_SURNAME = "Larionov";

    public static CreateAccountRequest getCreateAccountRequest() {
        return CreateAccountRequest.builder()
                .customerId(CUSTOMER_ID)
                .initialCredit(BigDecimal.ZERO)
                .build();
    }

   public static CustomerDto getCustomerDto() {
        return CustomerDto.builder()
                .id(CUSTOMER_ID)
                .name(CUSTOMER_NAME)
                .surname(CUSTOMER_SURNAME)
                .build();
    }

   public static CustomerEntity getCustomerEntity() {
        return CustomerEntity.builder()
                .id(CUSTOMER_ID)
                .name(CUSTOMER_NAME)
                .surname(CUSTOMER_SURNAME)
                .build();
    }

     public static CreatedAccountDto getCreatedAccountDto() {
        return CreatedAccountDto.builder()
                .balance(BigDecimal.ZERO)
                .id(ACCOUNT_ID)
                .creationDate(ACCOUNT_CREATION_DATE)
                .customer(getCustomerDto())
                .transactions(Collections.emptySet())
                .build();
    }

     public static AccountEntity getAccountEntity() {
        return AccountEntity.builder()
                .id(ACCOUNT_ID)
                .customer(getCustomerEntity())
                .balance(BigDecimal.ZERO)
                .transactions(Collections.emptySet())
                .creationDate(ACCOUNT_CREATION_DATE)
                .build();
    }

     public static AccountDto getAccountDto() {
        return AccountDto.builder()
                .id(ACCOUNT_ID)
                .balance(BigDecimal.ZERO)
                .transactions(Collections.emptySet())
                .creationDate(ACCOUNT_CREATION_DATE)
                .build();
    }
}
