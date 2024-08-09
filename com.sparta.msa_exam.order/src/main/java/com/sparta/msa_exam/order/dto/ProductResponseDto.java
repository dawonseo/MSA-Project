package com.sparta.msa_exam.order.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponseDto {
    private Long product_id;
    private String name;
    private Integer supply_price;
}
