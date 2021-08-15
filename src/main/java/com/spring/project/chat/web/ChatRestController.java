package com.spring.project.chat.web;


import com.spring.project.util.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatRestController {

    @PostMapping("/room")
    public ResponseEntity<?> room(){
        return ResponseEntity.ok(new ResponseModel(1));
    }
}
