package com.sparta.msa_exam.product.entity;

import com.sparta.msa_exam.product.dto.AddProductRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;
    private Integer supply_price;

    public Product(AddProductRequestDto requestDto) {
        this.name = requestDto.getName();
        this.supply_price = requestDto.getSupply_price();
    }
}
