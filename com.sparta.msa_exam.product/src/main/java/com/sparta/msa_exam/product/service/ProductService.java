package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.AddProductRequestDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(AddProductRequestDto requestDto) {
        productRepository.save(new Product(requestDto));
    }
}
