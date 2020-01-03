package com.hj.board.domain.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hj.board.domain.user.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseModel {

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    private String name;

    public Role(final String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
