package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Roles")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String roleID;

    String fullname;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authorities> authorities;
}
