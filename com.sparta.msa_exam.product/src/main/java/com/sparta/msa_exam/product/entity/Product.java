package com.sparta.msa_exam.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long product_id;
    private String name;
    private Integer supply_price;
}
