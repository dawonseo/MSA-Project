package com.sparta.msa_exam.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/products")
    public void addProduct() {

    }
}
