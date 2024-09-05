package com.tccmaster.projectccmaster.aplication.webSocket.controller;

import com.tccmaster.projectccmaster.aplication.webSocket.dto.ChatMensagem;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketController {
    @MessageMapping("/chat/{roomId}")
    @SendTo("/chat/mensagem/{roomId}")
    public ChatMensagem chat(@DestinationVariable String roomId, ChatMensagem mensagem){
        return new ChatMensagem(mensagem.getMensagem(), mensagem.getUser());
    }
}
