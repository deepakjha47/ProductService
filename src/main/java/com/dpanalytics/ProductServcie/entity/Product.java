package com.dpanalytics.ProductServcie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    /**
     * generate type = auto used to increment product id 1 by 1
     * @COLUMN is used to rename the schema as per our desired value
     * @Data is used to create pojo class no need to getter or setter
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name="PRODUCT_NAME")
    private String productName;

    @Column(name="PRICE")
    private long price;

    @Column(name="QUANTITY")
    private long quantity;

}
