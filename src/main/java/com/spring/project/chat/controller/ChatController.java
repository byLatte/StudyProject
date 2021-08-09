package com.spring.project.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chat/index")
    public String index(Model model){
        model.addAttribute("currentPage","chat");
        return "view/chat/index";
    }
}
