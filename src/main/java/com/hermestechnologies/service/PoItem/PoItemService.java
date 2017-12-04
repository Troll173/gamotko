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

    private List<PoItem> getQueuedProducts(){
        List<PoItem> queuedItems = poItemDao.getQueued();
        List<PoItem> products = new ArrayList<PoItem>();
        for (Iterator<PoItem> i = queuedItems.iterator(); i.hasNext();){
            products.add(i.next());
        }
        return products;
    }


    private PoItem containsProduct(List<PoItem> productList, Product product){
        PoItem res = null;
        for (Iterator<PoItem> prod = productList.iterator(); prod.hasNext();){
            PoItem poItem = prod.next();
            if(poItem.getProduct().getId().equals(product.getId())){
                res = poItem;
            }
        }
        return res;
    }

    @Transactional
    public List<HashMap<String,Object>> getQueuedItems(List<Supplier> suppliers){
        List<PoItem> queuedItems = this.getQueuedProducts();
        List<HashMap<String,Object>> res = new ArrayList<HashMap<String, Object>>();
        for (Iterator<Supplier> si = suppliers.iterator(); si.hasNext();){

            HashMap<String,Object> data = new HashMap<String, Object>();

            Supplier supplier = si.next();
            List<PoItem> productList = new ArrayList<PoItem>();
            for (Iterator<SupplierProduct> it = supplier.getSupplierProducts().iterator(); it.hasNext(); ) {
                SupplierProduct supplierProduct = it.next();
                PoItem poItem =this.containsProduct(queuedItems, supplierProduct.getProduct());

                if(poItem != null){
                    productList.add(poItem);
                }
            }
            data.put("supplier",supplier);
            data.put("products",productList);
            res.add(data);
        }
        return res;
    }


}
