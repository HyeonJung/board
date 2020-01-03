package com.hj.board.domain.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hj.board.domain.user.model.base.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class User extends BaseModel {

    @Column(unique=true)
    private String username; // 아이디

    @Column
    @JsonIgnore
    private String password; // 비밀번호

    @Column
    private String name; // 이름

    @Column
    private String tel; // 전화번호

    @Column
    @JsonIgnore
    private boolean accountNonExpired = true; // 계정 만료 여부

    @Column
    @JsonIgnore
    private boolean accountNonLocked = true; // 계정 잠김 여부

    @Column
    @JsonIgnore
    private boolean credentialsNonExpired = true; // 패스워드 만료 여부

    @Column(unique=true)
    private String email; // 이메일

    @Column
    private boolean enabled; // 활성화 여부

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles; // 권한
}
