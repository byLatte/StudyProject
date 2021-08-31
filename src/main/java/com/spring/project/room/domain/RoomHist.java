package com.spring.project.room.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class RoomHist {
    @Id
    @GeneratedValue
    Integer id;
    String userId;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
