package com.hermestechnologies.service.Supplier;

import com.hermestechnologies.domain.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierDao supplierDao;

    @Transactional
    public Supplier getSupplier(Integer id){
        return supplierDao.getSupplier(id);
    }

    @Transactional
    public List<Supplier> getSupplierList(){
        return supplierDao.getSupplierList();
    }

    @Transactional
    public Supplier saveSupplier(Supplier supplier){
        return supplierDao.saveSupplier(supplier);
    }

}
