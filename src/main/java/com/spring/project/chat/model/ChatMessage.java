package com.spring.project.chat.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessage {

    private String roomId;
    private String sender;
    private String message;
    private MessageType type;
    private LocalDateTime timestamp = LocalDateTime.now();

}
