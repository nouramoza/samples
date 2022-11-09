package com.blu.bankservice.account.service.serviceImpl;

import com.blu.bankservice.account.service.BankService;
import com.blu.bankservice.card.entity.CardEntity;
import com.blu.bankservice.card.repository.CardRepository;
import com.blu.bankservice.card.web.dto.CardDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import com.blu.bankservice.infrastructure.util.ConstantsUtil;
import com.blu.bankservice.infrastructure.util.ErrorConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Service Implementation for Bank-Service .
 */

@Service
public class BankServiceImpl implements BankService {

    public static final String VERIFICATION_KEY = "VerificationKey";

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public BankRestResponse getCardVerification(CardDto cardDto) {
        BankRestResponse restResponse;
        try {
            CardEntity cardEntity = cardRepository.findByCardNumber(cardDto.getCardNumber());
            if (cardEntity != null) {
                if (cardEntity.getIsActive() && !cardEntity.getExpireDate().before(new Date())) {
                    httpSession.setAttribute(VERIFICATION_KEY, cardDto);
                    restResponse = new BankRestResponse(BankRestResponse.STATUS.SUCCESS, ConstantsUtil.ResponseMessage.CARD_ACCEPTED);

                } else {
                    if (!cardEntity.getIsActive()) {
                        restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ErrorConstants.CardVerificationMessage.CARD_NOT_VALID_MSG);
                    } else if (cardEntity.getExpireDate().before(new Date())) {
                        restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ErrorConstants.CardVerificationMessage.CARD_EXPIRED_MSG);
                    } else {
                        restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ErrorConstants.CardVerificationMessage.CARD_NOT_VALID_MSG);
                    }
                }
            } else {
                restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ErrorConstants.CardVerificationMessage.CARD_NOT_VALID_MSG);
            }
        } catch (Exception e) {
            restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, e.getStackTrace().toString());
        }
        return restResponse;
    }

    @Override
    public BankRestResponse getCardPinVerification(CardDto cardDto) {
        BankRestResponse restResponse;
        try {
            restResponse = getCardVerification(cardDto);
            if (restResponse.getStatus() == BankRestResponse.STATUS.SUCCESS) {

                CardEntity cardEntity = cardRepository.findByCardNumber(cardDto.getCardNumber());
                if (cardEntity != null) {
                    if (cardEntity.getPin().equals(cardDto.getPin())) {
                        cardEntity.setIncorrectPinCount(0);
                        cardRepository.saveAndFlush(cardEntity);

                        httpSession.setAttribute(VERIFICATION_KEY, cardDto);
                        restResponse = new BankRestResponse(BankRestResponse.STATUS.SUCCESS, ConstantsUtil.ResponseMessage.PIN_ACCEPTED);
                    } else {
                        cardEntity.setIncorrectPinCount(cardEntity.getIncorrectPinCount() + 1);
                        if (cardEntity.getIncorrectPinCount() == 3) {
                            cardEntity.setIsActive(false);
                            restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ConstantsUtil.ResponseMessage.CARD_BLOCKED);
                        } else {
                            restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, ErrorConstants.CardVerificationMessage.WRONG_PIN_MSG);
                        }
                        cardRepository.saveAndFlush(cardEntity);
                    }
                }
            } else {
                return restResponse;
            }
        } catch (Exception e) {
            restResponse = new BankRestResponse(BankRestResponse.STATUS.FAILURE, e.getStackTrace().toString());

        }
        return restResponse;
    }
}