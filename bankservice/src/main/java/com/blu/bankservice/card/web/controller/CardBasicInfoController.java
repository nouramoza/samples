package com.blu.bankservice.card.web.controller;

import com.blu.bankservice.card.service.CardService;
import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic-info")
public class CardBasicInfoController {
    private CardService cardService;

    public CardBasicInfoController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public BankRestResponse addCard(@RequestBody CardDto cardDto) {
        return cardService.addCard(cardDto);
    }

}
