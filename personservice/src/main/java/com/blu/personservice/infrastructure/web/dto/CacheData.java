package com.blu.personservice.infrastructure.web.dto;

import lombok.Getter;

@Getter
public class CacheData {

    @SuppressWarnings("unused")
    private final String cacheType;
    @SuppressWarnings("unused")
    private final boolean enabled;

    public static CacheData instance(final String cacheType, final boolean enabled) {
        return new CacheData(cacheType, enabled);
    }

    private CacheData(final String  cacheType, final boolean enabled) {
        this.cacheType = cacheType;
        this.enabled = enabled;
    }
}
