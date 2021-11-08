package com.cpgmn.account.service;

import com.cpgmn.account.BaseIT;
import com.cpgmn.account.common.ClientException;
import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.repository.CustomerRepository;
import com.cpgmn.account.web.dto.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static com.cpgmn.account.service.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerServiceTest extends BaseIT {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void throwsClientException_whenCustomerNotFound() {
        //when
        assertThrows(ClientException.class, () -> customerService.getByIdOrThrow(UUID.randomUUID()));
    }

    @Test
    void getsCustomerById() {
        //given
        saveCustomer(getCustomerEntity());
        var expectedDto = getCustomerDto();
        //when
        CustomerDto customerDto = customerService.getCustomerById(CUSTOMER_ID);
        //then
        assertEquals(expectedDto, customerDto);
    }

    private void saveCustomer(CustomerEntity customerEntity) {
        customerRepository.saveAndFlush(customerEntity);
    }

}