package co.develhope.websocket2.controller;

import co.develhope.websocket2.entities.ClientMessageDTO;
import co.develhope.websocket2.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @PostMapping("/client-message")
    public ResponseEntity messageToClients(@RequestBody MessageDTO message){
        simpMessagingTemplate.convertAndSend("/topic/broadcast",message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @MessageMapping("/client-message")
    @SendTo("/topic/broadcast")
    public MessageDTO messageFromClient(ClientMessageDTO message){
        System.out.println("message arrived: "+message.getClientMsg());
        return new MessageDTO(message.getClientName(), message.getClientAlert(),message.getClientMsg());
    }






}
