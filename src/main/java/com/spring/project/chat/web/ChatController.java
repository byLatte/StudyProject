package com.spring.project.chat.web;

import com.spring.project.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("currentPage","chat");
        return "view/chat/index";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("currentPage","chatList");
        model.addAttribute("rooms",chatService.findAll());
        return "view/chat/list";
    }

}
