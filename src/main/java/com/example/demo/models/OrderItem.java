package com.example.demo.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orderitems")
@Data

public class OrderItem  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    private int orderId;
    private int itemId;
    private String itemName;
    private int quantity;
    private int price;

    public OrderItem() {
    }

    public OrderItem(int orderId, int itemId, String itemName, int quantity, int price) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }


    @ManyToOne(optional=false)
    @JoinColumn(name="orderId", insertable=false, updatable=false)
    private Order order;

}
