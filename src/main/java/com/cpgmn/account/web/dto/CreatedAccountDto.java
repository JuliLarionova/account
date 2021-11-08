package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = CreatedAccountDto.CreatedAccountDtoBuilder.class)
public class CreatedAccountDto {
    UUID id;
    BigDecimal balance;
    LocalDateTime creationDate;
    Set<TransactionDto> transactions;
    CustomerDto customer;
}
