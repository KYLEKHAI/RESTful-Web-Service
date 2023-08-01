package com.kylekhai.restapp;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class Greeting_Controller {

    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/greeting")
    Greeting greeting(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
