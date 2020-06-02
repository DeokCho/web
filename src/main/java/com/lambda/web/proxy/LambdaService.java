package com.lambda.web.proxy;

import org.springframework.stereotype.Component;

@Component
public interface LambdaService<T> {
    public int max(int a, int b);
}
