package com.dpanalytics.ProductServcie.service;

import com.dpanalytics.ProductServcie.entity.Product;
import com.dpanalytics.ProductServcie.exception.ProductServiceCustomException;
import com.dpanalytics.ProductServcie.model.ProductRequest;
import com.dpanalytics.ProductServcie.model.ProductResponse;
import com.dpanalytics.ProductServcie.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.beans.BeanUtils.*;
import static org.springframework.beans.BeanUtils.copyProperties;

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

    @Override
    public ProductResponse getProductById(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("404", "Didn't found the product with id"));
        ProductResponse productResponse = new ProductResponse();
        log.info("Product fetched successfully");
        copyProperties(product, productResponse);
        return productResponse;
    }

    @Override
    public ProductResponse reduceProductQuantity(long productId, long quantity) {
        log.info("Fetching the product with ID: {}", productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("Product doesn't exist with given id "+productId,
                        "PRODUCT_NOT_FOUND"));

        if(product.getQuantity() < quantity){
            throw new ProductServiceCustomException("Insufficient quantity and we have only: " + product.getQuantity(), "PRODUCT NOT FOUND");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }
}
