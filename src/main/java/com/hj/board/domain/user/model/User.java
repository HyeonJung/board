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
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String name;

    @Column
    private String tel;

    @Column
    @JsonIgnore
    private boolean accountNonExpired = true;

    @Column
    @JsonIgnore
    private boolean accountNonLocked = true;

    @Column
    @JsonIgnore
    private boolean credentialsNonExpired = true;

    @Column(unique=true)
    private String email;

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;
}
