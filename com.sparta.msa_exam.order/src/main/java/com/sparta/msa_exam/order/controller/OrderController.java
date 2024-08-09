package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderProductRequestDto;
import com.sparta.msa_exam.order.dto.OrderRequestDto;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 주문 추가 API
    @PostMapping("/order")
    public void addOrder(@RequestBody OrderRequestDto requestDto) {
        orderService.addOrder(requestDto);
    }

    // 주문에 상품 추가 API
    @PostMapping("/order/{orderId}")
    public void addProductToOrder(@PathVariable("orderId") Long orderId,
                                  @RequestBody OrderProductRequestDto requestDto) {
        orderService.addProductToOrder(orderId, requestDto);
    }

}
