package com.tccmaster.projectccmaster.aplication.controller;

import com.tccmaster.projectccmaster.aplication.chatAI.form.ChatForm;
import com.tccmaster.projectccmaster.aplication.chatAI.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatAiController {

    static final String mensagemInicial = "Apresente 4 proposta de temas para tcc no campo de";

    @Autowired
    private ChatService chatService;

    @PostMapping("/generate")
    public ChatForm generateContent(@RequestBody ChatForm message) {
        String requestBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + mensagemInicial + message.getMessage() + "\"}]}]}";
        return chatService.generateContent(requestBody);
    }
}
