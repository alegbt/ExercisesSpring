package it.develhope.First_API_1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {


    @GetMapping("/{num}")
    public Integer factorial(@PathVariable Integer num) {
        if(num < 1) return 1;
        return num*factorial(num-1);
    }



}
