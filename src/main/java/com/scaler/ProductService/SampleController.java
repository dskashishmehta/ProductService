package com.scaler.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller supports REST API's(HTTP Requests)
//The Request coming to endpoint /hello, transfer them to this controller.
@RestController
@RequestMapping("/scaler") //Any request coming to this endpoint, transfer that request to the controller
public class SampleController {

    @GetMapping("/hello/{name}/{city}/{num}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("num") int num, @PathVariable("city") String city) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= num - 1; i++) {
            stringBuilder.append("Hello 8" + name + " " + city);
//            System.out.println("Hello " + name + " " + city);
        }
        return stringBuilder.toString();
    }
}

// Project Dependencies USED:-
// Spring Boot DevTools
// Lombok
// Spring Configuration Processor
// Spring Web