package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
@JsonDeserialize(builder = TransactionDto.TransactionDtoBuilder.class)
public class TransactionDto {
    UUID id;
    BigDecimal amount;
    @JsonProperty(value = "transaction_date")
    LocalDateTime transactionDate;
}
