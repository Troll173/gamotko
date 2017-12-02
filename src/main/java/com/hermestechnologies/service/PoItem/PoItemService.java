package com.hermestechnologies.service.PoItem;

import com.hermestechnologies.domain.PoItem;
import com.hermestechnologies.domain.Product;
import com.hermestechnologies.domain.Supplier;
import com.hermestechnologies.domain.SupplierProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class PoItemService {

    @Autowired
    PoItemDao poItemDao;

    @Transactional
    public void save(PoItem poItem){
        poItemDao.save(poItem);
    }

    private List<Product> getQueuedProducts(){
        List<PoItem> queuedItems = poItemDao.getQueued();
        List<Product> products = new ArrayList<Product>();
        for (Iterator<PoItem> i = queuedItems.iterator(); i.hasNext();){
            products.add(i.next().getProduct());
        }
        return products;
    }


    @Transactional
    public List<HashMap<String,Object>> getQueuedItems(List<Supplier> suppliers){
        List<Product> queuedItems = this.getQueuedProducts();
        List<HashMap<String,Object>> res = new ArrayList<HashMap<String, Object>>();
        for (Iterator<Supplier> si = suppliers.iterator(); si.hasNext();){

            HashMap<String,Object> data = new HashMap<String, Object>();

            Supplier supplier = si.next();
            System.out.println("supp here "+ supplier.getSupplier_name());
            List<SupplierProduct> productList = new ArrayList<SupplierProduct>();
            for (Iterator<SupplierProduct> it = supplier.getSupplierProducts().iterator(); it.hasNext(); ) {
                SupplierProduct supplierProduct = it.next();

                if(queuedItems.contains(supplierProduct.getProduct())){
                    productList.add(supplierProduct);
                }
            }
            data.put("supplier",supplier);
            data.put("products",productList);
            res.add(data);
        }
        return res;
    }


}
