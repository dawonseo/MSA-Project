package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.AddProductRequestDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 추가 API
    @PostMapping("/products")
    public void addProduct(@RequestBody AddProductRequestDto requestDto) {
        productService.addProduct(requestDto);
    }
}
