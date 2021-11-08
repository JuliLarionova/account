package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = ExtendedCustomerDto.ExtendedCustomerDtoBuilder.class)
public class ExtendedCustomerDto {
    CustomerDto customer;
    Set<AccountDto> accounts;
}
