package com.blu.bankservice.account.service;

import com.blu.bankservice.account.web.dto.AccountRequestDto;
import com.blu.bankservice.infrastructure.dto.BankRestResponse;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public BankRestResponse requestManagement(AccountRequestDto accountRequestDto);
}
