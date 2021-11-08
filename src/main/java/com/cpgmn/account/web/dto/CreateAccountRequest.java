package com.cpgmn.account.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@JsonDeserialize(builder = CreateAccountRequest.CreateAccountRequestBuilder.class)
public class CreateAccountRequest {
    @NotNull
    @NotBlank(message ="CustomerId must not be empty")
    @JsonProperty(value = "customer_id")
    UUID customerId;
    @NotNull
    @PositiveOrZero(message = "Initial credit value must not be negative value")
    @JsonProperty(value = "initial_credit")
    BigDecimal initialCredit;
}
