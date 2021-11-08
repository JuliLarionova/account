package com.cpgmn.account.service;

import com.cpgmn.account.common.ClientException;
import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.repository.CustomerRepository;
import com.cpgmn.account.web.dto.CustomerDto;
import com.cpgmn.account.web.dto.converter.CustomerEntityToDtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    private static final String CUSTOMER_NOT_FOUND = "Customer with id = %s not found";

    private final CustomerRepository repository;
    private final CustomerEntityToDtoConverter converter;

    public CustomerEntity getByIdOrThrow(UUID customerId) {
        return repository.findById(customerId)
                .orElseThrow(()->new ClientException(String.format(CUSTOMER_NOT_FOUND, customerId)));
    }

    public CustomerDto getCustomerById(UUID customerId) {
        return converter.convert(getByIdOrThrow(customerId));
    }
}
