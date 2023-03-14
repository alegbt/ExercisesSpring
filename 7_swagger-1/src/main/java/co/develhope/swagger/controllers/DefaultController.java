package co.develhope.swagger.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {


    @GetMapping
    public String helloDef(){return "Hello, thanks for visiting us!";}
}
