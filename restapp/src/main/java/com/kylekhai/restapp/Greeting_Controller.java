package com.kylekhai.restapp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Greeting_Controller {

    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    
    //Support different http method types
    @RequestMapping(method = RequestMethod.GET, path = "/greeting") 
    Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
