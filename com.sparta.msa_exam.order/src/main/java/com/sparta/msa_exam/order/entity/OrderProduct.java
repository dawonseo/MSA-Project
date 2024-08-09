package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_product")
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Long product_id;
}
