package com.spring.project.user.model;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {

    @NotEmpty(message = "이름을 입력해주세요.")
    private String userName;
    @NotEmpty(message = "아이디를 입력해주세요")
    private String userId;
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;
    @NotEmpty(message = "비밀번호확인을 입력해주세요")
    private String passwordConfirm;
    private String role = "ROLE_USER";
}
