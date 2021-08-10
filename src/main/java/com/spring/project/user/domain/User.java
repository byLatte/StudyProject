package com.spring.project.user.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer userNo;
    private String userName;
    private String userId;
    @JsonIgnore // json 제외
    private String password;

    @OneToMany(mappedBy = "user")
    private List<LoginHist> loginHists;
}
