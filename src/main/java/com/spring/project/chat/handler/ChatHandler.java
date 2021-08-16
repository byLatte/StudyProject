package com.spring.project.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.chat.model.ChatMessage;
import com.spring.project.chat.model.ChatRoom;
import com.spring.project.chat.model.MessageType;
import com.spring.project.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;
//    private static Map<String,WebSocketSession> list = new LinkedList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //payload 전송되는 데이터
        String payload = message.getPayload();
        log.info("payload " + payload);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);// object 맵핑!
        ChatRoom chatRoom = chatService.findByRoomId(chatMessage.getRoomId());
        //생성
        if(chatMessage.getType() == MessageType.CREATE){
            chatRoom = chatService.save(ChatRoom.create().sender(chatMessage.getSender()).webSocketSession(session));

            session.sendMessage(new TextMessage("room_id:"+chatRoom.getRoomId()));
        }
        // 입장
        else if(chatMessage.getType() == MessageType.ENTER){
            chatRoom.webSocketSession(session);
            chatMessage.setMessage(":"+chatMessage.getSender() + " 님이 입장하셨습니다.");
            for(WebSocketSession wss : chatRoom.getWebSocketSession()){
                wss.sendMessage(new TextMessage(chatMessage.getMessage()));
            }
        }
        //떠남
        else if(chatMessage.getType() == MessageType.LEAVE){
            chatMessage.setMessage(chatMessage.getSender() + " 님이 나가셨습니다.");
        }
        //메세지
        else if(chatMessage.getType() == MessageType.MESSAGE){
            log.info("msg " + chatMessage.getMessage());
            chatMessage.setMessage(chatMessage.getSender() + ":"+chatMessage.getMessage());
            for(WebSocketSession wss : chatRoom.getWebSocketSession()){
                wss.sendMessage(new TextMessage(chatMessage.getMessage()));
            }
        }else{
            log.info("ADMIN 입장");
        }
    }

}
