package com.dpanalytics.ProductServcie.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ProductServiceCustomException extends RuntimeException{

    private String errorMessage;
    private String errorCode;
    public ProductServiceCustomException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
