package com.spring.project.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ChatRoom {
    private String roomId;
    private String sender;
    private Set<WebSocketSession> webSocketSession = new HashSet<>();

    public static ChatRoom create(){
        return new ChatRoom();
    }

    public ChatRoom sender(String sender){
        this.sender = sender;
        return this;
    }
    public ChatRoom webSocketSession(WebSocketSession webSocketSession){
        this.webSocketSession.add(webSocketSession);
        return this;
    }
}
