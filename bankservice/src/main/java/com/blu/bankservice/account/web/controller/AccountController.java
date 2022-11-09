package com.blu.bankservice.account.web.controller;

import com.blu.bankservice.account.service.AccountService;
import com.blu.bankservice.account.web.dto.AccountRequestDto;
import com.blu.bankservice.card.web.controller.BankController;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-service")
public class AccountController {
    Logger log = LoggerFactory.getLogger(BankController.class);
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/requestManagement", method = RequestMethod.POST)
    public BankRestResponse requestManagement(@RequestBody AccountRequestDto accountRequestDto) {
        return accountService.requestManagement(accountRequestDto);

    }
}
