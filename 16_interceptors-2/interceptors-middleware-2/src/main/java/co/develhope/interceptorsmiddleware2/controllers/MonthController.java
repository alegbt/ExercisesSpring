package co.develhope.interceptorsmiddleware2.controllers;


import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/month")
public class MonthController {


    @GetMapping("")
    public Month month(HttpServletRequest request){
        Month myMonth = (Month)request.getAttribute("month");
        return myMonth;
    }


}
