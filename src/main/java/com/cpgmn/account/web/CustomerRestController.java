package com.cpgmn.account.web;

import com.cpgmn.account.service.AccountService;
import com.cpgmn.account.service.CustomerService;
import com.cpgmn.account.web.dto.CustomerDto;
import com.cpgmn.account.web.dto.ExtendedCustomerDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerService customerService;
    private final AccountService accountService;

    @ApiOperation(value = "Get customer info by id", response = CustomerDto.class)
    @GetMapping("/{customerId}")
    public ExtendedCustomerDto getCustomerById(@PathVariable UUID customerId) {
        return ExtendedCustomerDto.builder()
                .customer(customerService.getCustomerById(customerId))
                .accounts(accountService.getAccountsByCustomerId(customerId))
                .build();
    }
}
