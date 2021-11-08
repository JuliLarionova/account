package com.cpgmn.account.web.dto.converter;

import com.cpgmn.account.entity.CustomerEntity;
import com.cpgmn.account.web.dto.CustomerDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CustomerEntityToDtoConverter {

    CustomerDto convert(CustomerEntity entity);
}
