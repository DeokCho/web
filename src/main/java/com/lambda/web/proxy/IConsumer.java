package com.lambda.web.proxy;


@FunctionalInterface
public interface IConsumer<T> {
    public void accept(T t);
}
