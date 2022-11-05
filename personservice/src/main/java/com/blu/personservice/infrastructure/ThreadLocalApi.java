package com.blu.personservice.infrastructure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/thread-local")
public class ThreadLocalApi {

    @GetMapping
    public String testThreadLocal() {
        ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

        threadLocalValue.set(1);
        Integer result = threadLocalValue.get();
        System.out.println(result);

        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 2);
        System.out.println(threadLocal.get());

        threadLocal.remove();
        System.out.println(threadLocal.get());
        return result.toString();
    }
}
