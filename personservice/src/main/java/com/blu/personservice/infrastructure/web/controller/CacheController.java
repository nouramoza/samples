package com.blu.personservice.infrastructure.web.controller;//package com.blu.samples.infrastructure.api.web.controller;
//
//import com.blu.samples.infrastructure.api.service.RuntimeDelegatingCacheManager;
//import com.blu.samples.infrastructure.api.web.dto.CacheNameDto;
//import com.blu.samples.infrastructure.api.web.dto.response.GenericRestResponse;
//import io.swagger.annotations.*;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping(value = "/cache")
//@Component
//@Api(value = "Cache", description = "The following settings are possible for cache:\n" + "\n" + "No Caching: caching turned off\n" + "Single node: caching on for single instance deployments of platorm (works for multiple tenants but only one tomcat)\n" + "By default caching is set to No Caching. Switching between caches results in the cache been clear e.g. from Single node to No cache and back again would clear down the single node cache.")
//@AllArgsConstructor
//public class CacheController {
//
//    private final RuntimeDelegatingCacheManager cacheService;
//
//    @GetMapping("/cacheNames")
//    @ApiOperation(value = "Retrieve Cache Types", notes = "Returns the list of caches.\n" + "\n" + "Example Requests:\n" + "\n" + "caches")
//    public CacheNameDto retrieveAllCacheNames() {
//        final Collection<String> cacheNames = this.cacheService.retrieveAllCacheNames();
//        return new CacheNameDto(cacheNames);
//    }
//
//    @PostMapping("/clear")
//    @ApiOperation(value = "REST request to Clear Cache",
//            produces = "Application/JSON", response = GenericRestResponse.class, httpMethod = "POST")
//    public void clearCache(@RequestBody CacheNameDto cacheNameDto) {
//        this.cacheService.clearCache(cacheNameDto.getCacheNames());
//    }
//
//}
