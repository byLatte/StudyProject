package com.spring.project.chat.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ChatHandler extends TextWebSocketHandler {
//    private static Map<WebSocketSession,String> list = new HashMap<>();
    private static List<WebSocketSession> list = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //payload 전송되는 데이터
        String payload = message.getPayload();
        log.info("payload : " + payload);
        for(WebSocketSession socketSession : list){
            socketSession.sendMessage(message);
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
