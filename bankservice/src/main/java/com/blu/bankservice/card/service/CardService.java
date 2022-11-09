package com.blu.bankservice.card.service;

import com.blu.bankservice.account.web.dto.AccountDto;
import com.blu.bankservice.card.entity.CardEntity;
import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.stereotype.Service;

@Service
public interface CardService {
    public BankRestResponse addCard(CardDto cardDto);

    public BankRestResponse addAccount(AccountDto accountDto);

    public CardEntity findByCardNumber(String cardNumber);

}
