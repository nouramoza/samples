package com.blu.personservice.infrastructure.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum CacheType {

    INVALID(0, "cacheType.invalid"), //
    NO_CACHE(1, "cacheType.noCache"), //
    SINGLE_NODE(2, "cacheType.singleNode"), //
    MULTI_NODE(3, "cacheType.multiNode");

    private final Integer value;
    private final String code;

    private static final Map<Integer, CacheType> intToEnumMap = new HashMap<>();

    static {
        for (final CacheType type : CacheType.values()) {
            intToEnumMap.put(type.value, type);
        }
    }

    public static CacheType fromInt(final Integer value) {
        CacheType type = intToEnumMap.get(value);
        if (type == null) {
            type = INVALID;
        }
        return type;
    }

    private CacheType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    @Override
    public String toString() {
        return name().replace("_", " ");
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isNoCache() {
        return NO_CACHE.getValue().equals(this.value);
    }

    public boolean isEhcache() {
        return SINGLE_NODE.getValue().equals(this.value);
    }

    public boolean isDistributedCache() {
        return MULTI_NODE.getValue().equals(this.value);
    }
}
