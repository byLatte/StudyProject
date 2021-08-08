package com.spring.project.board.dto;

import com.spring.project.board.domain.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private LocalDateTime regDt;

    public Board toEntity() {
        return new Board(null,title,regDt);
    }
}
