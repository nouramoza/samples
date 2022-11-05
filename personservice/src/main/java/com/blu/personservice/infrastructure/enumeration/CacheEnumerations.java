package com.blu.personservice.infrastructure.enumeration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheEnumerations {

    public static String cacheType(final int id) {
        return cacheType(CacheType.fromInt(id));
    }

    public static String cacheType(final CacheType cacheType) {
        String optionData = "Invalid";
        switch (cacheType) {
            case INVALID:
                optionData = "Invalid";
            break;
            case NO_CACHE:
                optionData ="No cache";
            break;
            case SINGLE_NODE:
                optionData = "Single node";
            break;
            case MULTI_NODE:
                optionData ="Multi node";
            break;
        }
        return optionData;
    }
}
