package com.poly.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    String userID;
    String password;
    String fullname;
    String email;
    String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    List<Authorities> authorities;

}
