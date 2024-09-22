package com.dpanalytics.ProductServcie.controller;

import com.dpanalytics.ProductServcie.entity.Product;
import com.dpanalytics.ProductServcie.model.ProductRequest;
import com.dpanalytics.ProductServcie.model.ProductResponse;
import com.dpanalytics.ProductServcie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductServiceController {

    @Autowired
    private ProductService productService;

    /**
     * ResponseEntity is a class in Spring Framework, primarily used in the context
     * of Spring MVC and Spring Boot, to represent HTTP responses. It allows you to
     * customize the response body, headers, and status code for an HTTP response.
     */
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        long productId = productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<ProductResponse> reduceProductQuantity(@PathVariable("id") long productId,
                                                                 @RequestParam long quantity){
        ProductResponse productResponse = productService.reduceProductQuantity(productId, quantity);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
