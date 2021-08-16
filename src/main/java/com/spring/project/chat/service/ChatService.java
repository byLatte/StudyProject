package com.spring.project.chat.service;

import com.spring.project.chat.model.ChatRoom;
import com.spring.project.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatRoom save(ChatRoom chatRoom){
        String uid = UUID.randomUUID().toString();
        chatRoom.setRoomId(uid.substring(0,uid.indexOf("-")));
        chatRepository.save(chatRoom);
        return chatRoom;
    }

    public ChatRoom findByRoomId(String roomId){
        return chatRepository.findByRoomId(roomId);
    }

    public List<ChatRoom> findAll(){
        List chatRooms = chatRepository.findAll();
        Collections.reverse(chatRooms);
        return chatRooms;
    }
}
