package com.example.toranj.Core.DomainObjects;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product ;

    public Order() {
        this.orderDate = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Product getProduct(){
        return product ;
    }

    public void setProduct(Product product){
        this.product = product ;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}