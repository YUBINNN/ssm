package com.practice.ssm.service;

import com.practice.ssm.daomain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Product> findAll() throws Exception;

    void save(Product product);
}
