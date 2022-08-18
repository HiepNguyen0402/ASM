package com.poly.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "orderdetail")
public class OrderDetail  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double price;
    Integer quantity;
    @ManyToOne
    @JoinColumn(name = "product_ID")
    Product product;
    @ManyToOne
    @JoinColumn(name = "order_ID")
    Order order;
}