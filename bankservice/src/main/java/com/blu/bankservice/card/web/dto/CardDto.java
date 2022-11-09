package com.blu.bankservice.card.web.dto;

import com.blu.bankservice.account.web.dto.AccountDto;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CardDto {
    @NonNull
    public String cardNumber;
    public int cvv2;
    public Date expireDate;
    private String pin;
    private Boolean isActive;
    private int incorrectPinCount;
    private AccountDto accountDto;

}
