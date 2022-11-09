package com.blu.bankservice.account.service;

import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.stereotype.Service;

@Service
public interface BankService {

    public BankRestResponse getCardVerification(CardDto cardDto);

    public BankRestResponse getCardPinVerification(CardDto cardDto);

}
