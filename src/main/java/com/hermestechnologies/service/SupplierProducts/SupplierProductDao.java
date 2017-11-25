package com.hermestechnologies.service.SupplierProducts;

import com.hermestechnologies.domain.SupplierProduct;

import java.util.List;

public interface SupplierProductDao {

    List<SupplierProduct> GetProductsSupplied(Integer supplier_id);
    List<SupplierProduct> GetSuppliers(Integer product_id);

}
