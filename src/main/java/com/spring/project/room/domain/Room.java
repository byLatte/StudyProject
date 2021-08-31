package com.spring.project.room.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue
    Integer roomId;
    String roomName;
    String userId;
    LocalDateTime startTime;
    String useYn = "N";
}
