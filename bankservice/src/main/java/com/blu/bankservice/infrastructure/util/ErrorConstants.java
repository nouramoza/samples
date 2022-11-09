package com.blu.bankservice.infrastructure.util;

import java.net.URI;

public final class ErrorConstants {

    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    public static final String ERR_VALIDATION = "error.validation";
    public static final String PROBLEM_BASE_URL = "https://www.egs.com/problem";
    public static final URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
    public static final URI CONSTRAINT_VIOLATION_TYPE = URI.create(PROBLEM_BASE_URL + "/constraint-violation");
    public static final URI ENTITY_NOT_FOUND_TYPE = URI.create(PROBLEM_BASE_URL + "/entity-not-found");

    private ErrorConstants() {
    }

    public static class CardVerificationMessage {
        public static final String CARD_NOT_VALID_KEY = "cardNotValid";
        public static final String CARD_NOT_VALID_MSG = "This Card Number Is Not Valid.";
        public static final String WRONG_PIN_KEY = "wrongPin";
        public static final String WRONG_PIN_MSG = "Pin Number Is Wrong";
        public static final String CARD_EXPIRED_KEY = "cardExpired";
        public static final String CARD_EXPIRED_MSG = "Card Is Expired";
    }

    public static class AccountMessage {
        public static final String ACCOUNT_NOT_VALID_KEY = "accountNotValid";
        public static final String ACCOUNT_NOT_VALID_MSG = "The Account Is not Valid";
        public static final String ACCOUNT_IS_BLOCKED_KEY = "accountBlocked";
        public static final String ACCOUNT_IS_BLOCKED_MSG = "The Account is Blocked";
        public static final String NOT_ENOUGH_BALANCE_KEY = "notEnoughBalance";
        public static final String NOT_ENOUGH_BALANCE_MSG = "Your Balance is Less Than the RequestedAmount";
    }
}