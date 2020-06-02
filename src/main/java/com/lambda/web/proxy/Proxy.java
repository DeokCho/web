package com.lambda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Component("pxy") @Lazy
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String :: valueOf;
        return f.apply(o);
    }
    public int integer(String s){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    public Boolean equals(String t, String u){
        BiPredicate<String,String> f = String::equals;
        return f.test(t, u);
    }
    public void print(String t){
        Consumer<String> c = System.out::print;
        c.accept(t);
    }
}