package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductRequestDto;
import com.sparta.msa_exam.order.dto.OrderRequestDto;
import com.sparta.msa_exam.order.dto.ProductResponseDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.feignClient.ProductClient;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderProductRepository orderProductRepository;

    public void addOrder(OrderRequestDto requestDto) {
        orderRepository.save(Order.builder().name(requestDto.getName()).build());
    }

    @Transactional
    public void addProductToOrder(Long orderId, OrderProductRequestDto requestDto) {
        Long productId = requestDto.getProduct_id();
        List<ProductResponseDto> productResponseDtoList = productClient.getProductList();
        for (ProductResponseDto productResponseDto : productResponseDtoList) {
            if (Objects.equals(productResponseDto.getProduct_id(), productId)) {
                Order order = orderRepository.findById(orderId).orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 주문입니다.")
                );
                OrderProduct orderProduct = OrderProduct.builder().product_id(productId).build();
                order.addProductList(orderProduct);
                orderProductRepository.save(orderProduct);
                return;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 상품입니다.");
    }
}
