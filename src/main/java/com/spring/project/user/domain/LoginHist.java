package com.spring.project.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class LoginHist {

    @Id
    @GeneratedValue
    private Integer id;
    @CreationTimestamp
    private LocalDateTime loginDt;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable = true, name = "userNo")
    private User user;
}
