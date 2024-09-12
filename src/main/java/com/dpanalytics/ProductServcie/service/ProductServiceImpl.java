package com.dpanalytics.ProductServcie.service;

import com.dpanalytics.ProductServcie.entity.Product;
import com.dpanalytics.ProductServcie.model.ProductRequest;
import com.dpanalytics.ProductServcie.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product added");
        return product.getProductId();
    }
}
