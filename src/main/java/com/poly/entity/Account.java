package com.poly.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
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
    boolean role;
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;
}
