package com.poly.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
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
    @Column(name = "userID", nullable = false, length = 50)
    String userID;
    
    @Column(name = "password", nullable = false)
    String password;
    
    @Column(name = "fullname", nullable = false, length = 100)
    String fullname;
    
    @Column(name = "email", nullable = false, length = 50)
    String email;
    
    @Column(name = "phone", nullable = false, length = 50)
    String phone;
    
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    List<Order> orders;
    
    public Account() {
    	
    }

	public Account(String userID, String password, String fullname, String email, String phone,
			List<Order> orders) {
		super();
		this.userID = userID;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.orders = orders;
	}
    
    
    
}
