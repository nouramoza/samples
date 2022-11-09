package com.blu.bankservice.account.web.dto;

import com.blu.bankservice.infrastructure.enums.RequestTypeEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionLogDto {
    @NotNull
    private String accountNumber;
    @NotNull
    private RequestTypeEnum requestTypeEnum;
    @NotNull
    private Long newBalance;
    @NotNull
    private String response;
    @NotNull
    private int status;
    @NotNull
    private Date requestDate;
    public String description;
}
