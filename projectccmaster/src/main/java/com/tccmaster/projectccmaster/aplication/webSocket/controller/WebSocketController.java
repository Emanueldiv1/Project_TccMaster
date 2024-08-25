package com.tccmaster.projectccmaster.aplication.webSocket.controller;

import com.tccmaster.projectccmaster.aplication.webSocket.dto.ChatMensagem;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketController {
    @MessageMapping("/chat/{salaId}")
    @SendTo("/orientacao/{salaId}")
    public ChatMensagem chat(@DestinationVariable String salaId, ChatMensagem mensagem){
        return new ChatMensagem(mensagem.getMensagem(), mensagem.getUser());
    }
}
