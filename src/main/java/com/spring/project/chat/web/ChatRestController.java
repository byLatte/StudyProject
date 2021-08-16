package com.spring.project.chat.web;


import com.spring.project.chat.model.ChatRoom;
import com.spring.project.chat.service.ChatService;
import com.spring.project.util.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRestController {

    private final ChatService chatService;

    @PostMapping("/room")
    public ResponseEntity<?> room(ChatRoom chatRoom){
        chatRoom = chatService.save(chatRoom);
        return ResponseEntity.ok(new ResponseModel().create().status(HttpStatus.OK.value()).data(chatRoom));
    }
}
