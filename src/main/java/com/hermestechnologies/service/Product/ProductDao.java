package com.hermestechnologies.service.Product;

import com.hermestechnologies.domain.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProductList();
    Product getProduct(Integer id);
    Product save(Product product);

}
