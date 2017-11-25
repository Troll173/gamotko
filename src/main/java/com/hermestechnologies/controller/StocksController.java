package com.hermestechnologies.controller;

import com.hermestechnologies.domain.Product;
import com.hermestechnologies.domain.SupplierProduct;
import com.hermestechnologies.service.Product.ProductService;
import com.hermestechnologies.service.SupplierProducts.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StocksController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierProductService supplierProductService;

    @GetMapping("/inventory/products/stocks/{productId}")
    public String productStocks(@PathVariable Integer productId, Model model){
        Product product = productService.getProduct(productId);
        List<SupplierProduct> suppliers = supplierProductService.getSuppliers(productId);

        model.addAttribute("productName", product.getGeneric_name()+" "+product.getDosage()+" ("+product.getBrand_name()+")");
        model.addAttribute("stocks",product.getStocks());
        model.addAttribute("product",product);
        model.addAttribute("suppliers",suppliers);
        return "stocks";
    }


}
