package com.spring.project.room.service;

import com.spring.project.room.domain.Room;
import com.spring.project.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public void save(Room room){
        roomRepository.save(room);
    }

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public void reservation(Room room) throws Exception {
        Optional<Room> optionalRoom = roomRepository.findById(room.getRoomId());
        if(optionalRoom.isPresent()){
            Room rm = optionalRoom.get();
            if("Y".equals(rm.getUseYn())){
                throw new Exception("이미 예약되었습니다.");
            }else{
                rm.setUseYn(room.getUseYn());
                rm.setUserId(room.getUserId());
                rm.setStartTime(LocalDateTime.now());
                roomRepository.save(rm);
            }
        }
    }

}
