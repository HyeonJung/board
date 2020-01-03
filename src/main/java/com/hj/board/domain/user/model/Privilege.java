package com.hj.board.domain.user.model;

import com.hj.board.domain.user.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Privilege extends BaseModel {

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege(final String name) {
        this.name = name;
    }
}
