package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    BasicService basicService;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Value("${customEnvs.n1}")
    int var1;

    @Value("${customEnvs.n2}")
    int var2;

    @GetMapping("/")
    public String welcome(){
        return basicService.sayHello();
    }

   @GetMapping("/exp")
    public int expon(){
        return basicService.powerOf(var1,var2);
   }


    @GetMapping("/get-errors")
    public void getError(){
        Error error = new Error("new custom error");

        logger.error("this is logging errror", error);
    }





}
