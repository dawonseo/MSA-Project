package com.sparta.msa_exam.order.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto implements Serializable {
    private Long order_id;
    private List<Long> product_ids;
}
