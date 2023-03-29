package co.develhope.interceptorsmiddleware1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class BasicController {

    @GetMapping("/time")
    public LocalDateTime time(){
        return LocalDateTime.now();
    }

}
