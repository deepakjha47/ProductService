package com.dpanalytics.ProductServcie.service;

import com.dpanalytics.ProductServcie.model.ProductRequest;
import com.dpanalytics.ProductServcie.model.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);
    public ProductResponse getProductById(long productId);
}
