package com.blu.bankservice.account.web.dto;

import com.blu.bankservice.card.web.dto.CardDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AccountDto {
    private List<CardDto> cardDtoList;

    @NonNull
    private String accountNumber;

    @NotNull
    private Long personId;

    @NotNull
    private Long balance;

    private Boolean isActive;

    private List<TransactionLogDto> transactionList;

}
