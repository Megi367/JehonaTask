package com.example.demo.models;

import lombok.Data;


import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data

public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    private int id;
    private String orderName;
    private int userId;
    public Order() {

    }

    public Order(int id, String orderName, int userId) {
        this.id = id;
        this.orderName = orderName;
        this.userId = userId;
    }

    @ManyToOne (optional=false)
    @JoinColumn(name="userId", insertable=false, updatable=false)
    private User user;

}
