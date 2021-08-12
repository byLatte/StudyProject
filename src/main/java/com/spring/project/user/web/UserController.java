package com.spring.project.user.web;

import com.spring.project.user.domain.User;
import com.spring.project.user.model.UserForm;
import com.spring.project.user.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final LoginService loginService;

    public UserController(LoginService loginService) {
        this.loginService = loginService;
    }

    // ModelAttribute userForm initialize
    @ModelAttribute
    UserForm userFormModelInit(){
        return new UserForm();
    }

    @GetMapping("/index")
    public String login(){
        return "view/user/index";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        return "view/user/sign_up";
    }

    // item 다음 bindingResult가 와야함.
    // modelAttribute userForm 생성 해줘야함.
    @PostMapping("/signup")
    public String signUp(@Validated UserForm userForm, BindingResult result, Model model){
        if(result.hasErrors()){
            return signUp(model);
        }else if(!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            result.addError(new FieldError("userForm","passwordConfirm","비밀번호와 비밀번호 확인이 서로 다릅니다."));
            return signUp(model);
        }else if(loginService.findByUserId(userForm.getUserId()) != null){
            result.addError(new FieldError("userForm","userId","아이디가 존재합니다."));
            return signUp(model);
        }else{
            User user = new User();
            BeanUtils.copyProperties(userForm,user); // userForm을 user에 복사

            loginService.save(user);
            return "view/index";
        }
    }
}
