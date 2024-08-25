package com.tccmaster.projectccmaster.aplication.webSocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMensagem {
    String mensagem;
    String user;
}
