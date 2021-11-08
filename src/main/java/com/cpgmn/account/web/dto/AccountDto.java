package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = AccountDto.AccountDtoBuilder.class)
public class AccountDto {
    UUID id;
    BigDecimal balance;
    Set<TransactionDto> transactions;
    @JsonProperty(value = "creation_date")
    LocalDateTime creationDate;
}
