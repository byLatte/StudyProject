package com.spring.project.board.controller;

import com.spring.project.board.domain.Board;
import com.spring.project.board.dto.BoardDto;
import com.spring.project.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/index")
    public String index(Model model){
        model.addAttribute("currentPage","board");
        return "view/board/index";
    }

    @GetMapping("/board/edit")
    public String reg(Model model){
        model.addAttribute("currentPage","board");
        return "view/board/edit";
    }

    @GetMapping("/board")
    @ResponseBody
    public ResponseEntity<?> findAll(Pageable pageable){
        Page<Board> page = boardService.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping("/board")
    @ResponseBody
    public ResponseEntity<?> save(BoardDto boardDto){
        boardService.save(boardDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
