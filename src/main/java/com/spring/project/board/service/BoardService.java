package com.spring.project.board.service;

import com.spring.project.board.domain.Board;
import com.spring.project.board.dto.BoardDto;
import com.spring.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> findAll(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public void save(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }
}
