package com.hermestechnologies.service.Supplier;

import com.hermestechnologies.domain.Supplier;

import java.util.List;

public interface SupplierDao {

    Supplier getSupplier(Integer id);
    List<Supplier> getSupplierList();
    Supplier saveSupplier(Supplier supplier);

}
