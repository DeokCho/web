package com.lambda.web.proxy;

@FunctionalInterface
public interface IFunction<T, R> {
    public R apply(T t);
}
