package com.spring.project.room.web;

import com.spring.project.room.domain.Room;
import com.spring.project.room.service.RoomService;
import com.spring.project.util.ResponseModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class RoomRestController {

    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<ResponseModel> addRoom(@Validated Room room, BindingResult result, Model model){
        if (room.getRoomName().trim().length() > 0){
            roomService.save(room);
            return ResponseEntity.ok(new ResponseModel().create().status(HttpStatus.OK.value()));
        }else{
            result.addError(new FieldError("room","roomName","방 이름을 정확히 입력해주세요"));
            return ResponseEntity.ok(new ResponseModel().create().status(HttpStatus.BAD_REQUEST.value()));
        }
    }

    @PatchMapping("/room")
    public ResponseEntity<ResponseModel> update(Room room, Principal principal) throws Exception {
        if("Y".equals(room.getUseYn())){
            room.setUserId(principal.getName());
            roomService.reservation(room);
        }
        return ResponseEntity.ok(new ResponseModel().create().status(HttpStatus.OK.value()));
    }

    @GetMapping("/rooms")
    public ResponseEntity<ResponseModel> findAll(){
        List<Room> rooms = roomService.findAll();
        return ResponseEntity.ok(new ResponseModel().create().status(HttpStatus.OK.value()).data(rooms));
    }
}
