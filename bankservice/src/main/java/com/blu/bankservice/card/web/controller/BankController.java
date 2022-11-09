package com.blu.bankservice.card.web.controller;

import com.blu.bankservice.account.service.BankService;
import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bank-service")
public class BankController {

    Logger log = LoggerFactory.getLogger(BankController.class);
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @RequestMapping(value = "/validateCardNumber", method = RequestMethod.POST)
    public BankRestResponse validateCardNumber(@RequestBody CardDto cardDto) {
        return bankService.getCardVerification(cardDto);
    }

    @RequestMapping(value = "/validateCardPinNumber", method = RequestMethod.POST)
    public BankRestResponse validateCardPinNumber(@RequestBody CardDto cardDto) {
        return bankService.getCardPinVerification(cardDto);
    }
}
