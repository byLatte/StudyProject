package com.spring.project.room.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("currentPage","room");
        return "view/room/index";
    }
}