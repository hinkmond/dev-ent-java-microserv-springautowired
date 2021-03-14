package com.hinkmond.hello;

import org.springframework.stereotype.Component;

@Component("MyGreetingFactory")
public class GreetingFactory {

    public Greeting create(long id, String content) {
        return new GreetingImpl(id, content);
    }

}