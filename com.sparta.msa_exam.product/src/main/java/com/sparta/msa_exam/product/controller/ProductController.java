package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.AddProductRequestDto;
import com.sparta.msa_exam.product.dto.ProductResponseDto;
import com.sparta.msa_exam.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 상품 추가 API
    @CacheEvict(cacheNames = "productAllCache", allEntries = true)
    @PostMapping("/products")
    public void addProduct(@RequestBody AddProductRequestDto requestDto) {
        productService.addProduct(requestDto);
    }

    // 상품 목록 조회 API
    @Cacheable(cacheNames = "productAllCache")
    @GetMapping("/products")
    public List<ProductResponseDto> getProductList() {
        return productService.getProductList();
    }
}
