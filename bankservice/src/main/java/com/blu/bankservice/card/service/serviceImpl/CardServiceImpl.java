package com.blu.bankservice.card.service.serviceImpl;

import com.blu.bankservice.account.entity.AccountEntity;
import com.blu.bankservice.account.repository.AccountRepository;
import com.blu.bankservice.account.web.dto.AccountDto;
import com.blu.bankservice.card.entity.CardEntity;
import com.blu.bankservice.card.repository.CardRepository;
import com.blu.bankservice.card.service.CardService;
import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BankRestResponse addCard(CardDto cardDto) {

        BankRestResponse restResponse;

        AccountEntity accountEntity = accountRepository.findByAccountNumber(cardDto.getAccountDto().getAccountNumber());

        CardEntity cardEntity = new CardEntity(null, accountEntity, cardDto.getCardNumber(),
                cardDto.getCvv2(), cardDto.getExpireDate(),
                cardDto.getPin(), 0, cardDto.getIsActive());

        cardRepository.saveAndFlush(cardEntity);
        return new BankRestResponse(BankRestResponse.STATUS.SUCCESS, cardEntity.getId().toString());
    }

    @Override
    public BankRestResponse addAccount(AccountDto accountDto) {
        BankRestResponse restResponse;

        AccountEntity accountEntity = new AccountEntity(null, accountDto.getAccountNumber(),
                accountDto.getPersonId(), accountDto.getBalance(), accountDto.getIsActive());

        accountRepository.saveAndFlush(accountEntity);
        return new BankRestResponse(BankRestResponse.STATUS.SUCCESS, accountEntity.getId().toString());
    }

    @Override
    @Cacheable(value = "cardCache", key = "#cardNumber")
    public CardEntity findByCardNumber(String cardNumber) {

        CardEntity cardEntity = cardRepository.findByCardNumber(cardNumber);

        return cardEntity;
    }
}
