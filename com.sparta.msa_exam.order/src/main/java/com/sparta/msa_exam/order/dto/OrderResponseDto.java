package com.sparta.msa_exam.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class OrderResponseDto {
    private Long order_id;
    private List<Long> product_ids;
}
