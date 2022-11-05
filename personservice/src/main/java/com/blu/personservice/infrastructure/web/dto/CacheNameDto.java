package com.blu.personservice.infrastructure.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class CacheNameDto implements Serializable {
    private Collection<String> cacheNames;

    public CacheNameDto(Collection<String> cacheNames) {
        this.cacheNames = cacheNames;
    }
}
