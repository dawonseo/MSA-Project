package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductRequestDto {
    private String name;
    private Integer supply_price;
}
