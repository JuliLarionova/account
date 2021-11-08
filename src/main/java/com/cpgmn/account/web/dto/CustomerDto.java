package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = CustomerDto.CustomerDtoBuilder.class)
public class CustomerDto {
    UUID id;
    String name;
    String surname;
}
