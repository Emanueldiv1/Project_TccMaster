package com.tccmaster.projectccmaster.aplication.webSocket.controller;

import com.tccmaster.projectccmaster.aplication.webSocket.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    @MessageMapping("/chat/{roomId}") // endpoint para receber a mensagem
    @SendTo("/topic/{roomId}") // endpoint para enviar a mensagem
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message){
        System.out.println(message);
        return new ChatMessage(message.getMessage(), message.getUser());
    }
}
