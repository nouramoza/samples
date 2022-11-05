package com.blu.personservice.infrastructure.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public final class ConstantsUtil {

    public static class ResponseMessage {
        public static final String PERSON_FOUNDED = "Person Founded";
        public static final String PERSON_ADDED_SUCCESSFULLY = "Person Added Successfully.";
        public static final String PERSON_UPDATED_SUCCESSFULLY = "Person Updated Successfully.";
        public static final String PERSON_DELETED_SUCCESSFULLY = "Person Deleted Successfully.";
    }

    public static class CardValidityValues {
        public static final int CASH_CARD_VALIDATION_YEAR = 2;
        public static final int CREDIT_CARD_VALIDATION_YEAR = 5;
    }

    public static class SpecialCharacter {
        public static final String COMMA = ",";
    }
}