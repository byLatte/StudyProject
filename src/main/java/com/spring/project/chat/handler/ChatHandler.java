package com.spring.project.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.chat.model.ChatMessage;
import com.spring.project.chat.model.ChatRoom;
import com.spring.project.chat.model.MessageType;
import com.spring.project.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {
    private final ChatRepository chatRepository;
    private final ObjectMapper objectMapper;
    private static List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //payload 전송되는 데이터
        String payload = message.getPayload();
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);// object 맵핑!
        ChatRoom chatRoom = chatRepository.findRoomById(chatMessage.getRoomId());

        // 입장
        if(chatMessage.getType() == MessageType.ENTER){
            chatMessage.setMessage(chatMessage.getSender() + " 님이 입장하셨습니다.");
        }
        //떠남
        else if(chatMessage.getType() == MessageType.LEAVE){
            chatMessage.setMessage(chatMessage.getSender() + " 님이 나가셨습니다.");
        }
        //메세지
        else if(chatMessage.getType() == MessageType.MESSAGE){
            chatMessage.setMessage(chatMessage.getSender() + ":"+chatMessage.getMessage());
        }

        for(WebSocketSession ws : list){
            ws.sendMessage(new TextMessage(chatMessage.getMessage()));
        }
    }


    // 접속
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info(session + " 접속함");
    }

    // 접속 해제
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " 접속해제");
        list.remove(session);
        for(WebSocketSession socketSession : list){
            socketSession.sendMessage(new TextMessage("나감"));
        }
    }
}
