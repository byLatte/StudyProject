package com.spring.project.chat.repository;

import com.spring.project.chat.model.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ChatRepository {

    private final Map<String, ChatRoom> chatRoomMap;

    public ChatRepository() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public ChatRoom findByRoomId(String roomId){
        return chatRoomMap.get(roomId);
    }

    public void save(ChatRoom chatRoom){
        chatRoomMap.put(chatRoom.getRoomId(),chatRoom);
    }

    public void update(ChatRoom chatRoom){
        chatRoomMap.put(chatRoom.getRoomId(),chatRoom);
    }
    public void remove(String roomId){
        chatRoomMap.remove(roomId);
    }

    public List<ChatRoom> findAll(){
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        return chatRooms;
    }
}
