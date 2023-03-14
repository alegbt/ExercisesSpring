package co.develhope.firstapi4.controllers;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.Map;

@RestController
public class HeaderController2 {


//    @GetMapping("/req")
//    public String req(HttpServletRequest request){
//        String name = request.getServerName();
//        int port = request.getServerPort();
//        return "server name: "+name+"\n server port: "+port;
//    }



@GetMapping("/headers")
public String headers(@RequestHeader(value = "Host") String host){
    String[] ports = host.split(":");
    String hostName = ports[0];
    String port = ports[1];
    return "server name: "+hostName+"\n server port: "+ port;
}





}
