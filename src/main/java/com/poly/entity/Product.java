package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity @Table(name = "products")
public class Product  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer product_ID;
    String product_Name;
    String product_Image;
    Double product_Price;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    Date create_date = new Date();
    @ManyToOne
    @JoinColumn(name = "cate_ID")
    Category category;

    @ManyToOne
    @JoinColumn(name = "userID")
    Account account;
}