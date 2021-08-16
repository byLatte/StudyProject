package com.spring.project.chat.web;


import com.spring.project.chat.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class StompChatController {

    @MessageMapping("/{id}/register")
    @SendTo("/queue/{id}")
    public ChatMessage register(@Payload ChatMessage msg, @PathVariable String id){
        log.info(" 입장 ");
        msg.setMessage(msg.getSender() + " 님이 입장하였습니다.");
        return msg;
    }

    @MessageMapping("/{id}")
    @SendTo("/queue/{id}")
    public ChatMessage send(@Payload ChatMessage msg, @PathVariable String id){
        log.info(">>msg : " + msg);
        return msg;
    }

}
