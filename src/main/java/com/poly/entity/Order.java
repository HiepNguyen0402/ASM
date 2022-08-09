package com.poly.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orders")
public class Order  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer order_ID;
    String address;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    Date create_date = new Date();
    @ManyToOne
    @JoinColumn(name = "userID")
    Account account;

}