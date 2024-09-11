package com.tccmaster.projectccmaster.aplication.webSocket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    String message;
    String user;
}
