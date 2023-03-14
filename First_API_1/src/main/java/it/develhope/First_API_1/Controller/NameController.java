package it.develhope.First_API_1.Controller;

import it.develhope.First_API_1.Services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NameController {
    @Autowired
    NameService nameService;

    @GetMapping("/name")
    public String get(){
        return nameService.regName();
    }

    @PostMapping("/name")
    public StringBuilder post(){
        return nameService.revName();
    }


}
