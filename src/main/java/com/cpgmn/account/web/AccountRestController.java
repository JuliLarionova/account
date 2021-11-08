package com.cpgmn.account.web;

import com.cpgmn.account.service.AccountService;
import com.cpgmn.account.web.dto.CreateAccountRequest;
import com.cpgmn.account.web.dto.CreatedAccountDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountService accountService;

    @ApiOperation(value = "Create new account for customer", response = CreatedAccountDto.class)
    @PostMapping
    public CreatedAccountDto createAccount(@Valid @RequestBody CreateAccountRequest request){
        return accountService.createAccount(request);
    }

}
