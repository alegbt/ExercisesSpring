package it.develhope.First_API_1.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class StringController {

//a StringController that:
//is mapped on strings
//returns the concatenation of 2 strings (the first is mandatory, the second is not) params
//handle the case where the second string is null (we want to return just the first string)
//test the API endpoint with Postman, executing 2 GET requests:
//with just the first param
//with both the params


    //questo funziona con l'url stesso
//@RequestMapping({"{str1}","/{str1}/{str2}"})
//    public String str (@PathVariable String str1, @PathVariable(required = false) String str2){
//    if(str2 != null){
//        return str1.concat(str2);
//    }else{
//        return str1;
//    }
//


//questo funziona con key-value di postman
    @GetMapping("/abc")
    public String str22 (@RequestParam String str1, @RequestParam(required = false) String str2) {
        if(str2 != null){
        return str1.concat(str2);
    }else{
        return str1;
    }





}
}
