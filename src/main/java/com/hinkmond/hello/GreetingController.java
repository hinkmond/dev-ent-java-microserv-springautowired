package com.hinkmond.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {
    GreetingFactory greetingFactory;

    @Autowired
    @Qualifier("MyGreetingFactory")
    public void setInjectedGreetingFactory(GreetingFactory greetingFactory) {
        this.greetingFactory = greetingFactory;
    }

    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="paramString", defaultValue="World from Greeting") String paramString) {
        return greetingFactory.create(counter.incrementAndGet(),
                String.format(template, paramString));
    }
}