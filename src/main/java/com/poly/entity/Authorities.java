package com.poly.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Data
@Entity
@Table( name = "Authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userID", "roleID"})
})
public class Authorities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;

}
