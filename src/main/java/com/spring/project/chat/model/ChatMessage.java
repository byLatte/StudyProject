package com.spring.project.chat.model;

import lombok.Data;

@Data
public class ChatMessage {

    private String roomId;
    private String sender;
    private String message;
    private MessageType type;

}
