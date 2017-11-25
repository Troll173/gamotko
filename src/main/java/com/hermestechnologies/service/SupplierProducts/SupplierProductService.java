package com.hermestechnologies.service.SupplierProducts;

import com.hermestechnologies.domain.SupplierProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierProductService {

    @Autowired
    SupplierProductDao supplierProductDao;

    @Transactional(readOnly = true)
    public List<SupplierProduct> getSuppliers(Integer product_id){
        return supplierProductDao.GetSuppliers(product_id);
    }

    @Transactional(readOnly = true)
    public List<SupplierProduct> getProducts(Integer supplier_id){
        return supplierProductDao.GetProductsSupplied(supplier_id);
    }


}
