package com.lambda.web.proxy;

@FunctionalInterface
public interface ISupplier<T> {
    public T get();
}
