package com.blu.bankservice.account.web.controller;

import com.blu.bankservice.account.web.dto.AccountDto;
import com.blu.bankservice.card.service.CardService;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic-info")
public class AccountBasicInfoController {
    private CardService cardService;

    public AccountBasicInfoController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public BankRestResponse addAccount(@RequestBody AccountDto accountDto) {
        return cardService.addAccount(accountDto);
    }

}
