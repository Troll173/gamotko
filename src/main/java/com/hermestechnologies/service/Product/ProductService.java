package com.hermestechnologies.service.Product;

import com.hermestechnologies.domain.Product;
import com.hermestechnologies.service.HermesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends HermesService{

    @Autowired
    ProductDao productDao;

    @Transactional(readOnly = true)
    public List<Product> getProductList(){
        return productDao.getProductList();
    }

    @Transactional
    public Product save(Product product){
        return productDao.save(product);
    }

    @Transactional
    public Product getProduct(Integer id){
        return productDao.getProduct(id);
    }


}
