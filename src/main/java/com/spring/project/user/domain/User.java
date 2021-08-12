package com.spring.project.user.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer userNo;
    private String userName;
    private String userId;
    @JsonIgnore // json 제외
    private String password;

    //LAZY 지연로딩, EAGER 즉시로딩
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<LoginHist> loginHists;
}
