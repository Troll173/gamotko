package com.hermestechnologies.controller;


import com.hermestechnologies.domain.Supplier;
import com.hermestechnologies.domain.SupplierProduct;
import com.hermestechnologies.service.Supplier.SupplierService;
import com.hermestechnologies.service.SupplierProducts.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/inventory/")
public class SupplierController {


    @Autowired
    SupplierService supplierService;

    @Autowired
    SupplierProductService supplierProductService;

    @GetMapping("supplier/{supplier_id}")
    public String getSupplier(@PathVariable Integer supplier_id, Model model){
        Supplier supplier = supplierService.getSupplier(supplier_id);
        List<SupplierProduct> products = supplierProductService.getProducts(supplier_id);
        model.addAttribute("supplier", supplier);
        model.addAttribute("products", products);
        return "supplier";
    }

    @GetMapping("suppliers")
    public String getSupplierList(Model model){
        List<Supplier> suppliers = supplierService.getSupplierList();
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("newSupplier", new Supplier());
        System.out.println(suppliers);
        return "suppliers";
    }

    @PostMapping("suppliers")
    public ModelAndView addSupplier(@ModelAttribute Supplier supplier, Model model){
        supplierService.saveSupplier(supplier);
        return new ModelAndView("redirect:/inventory/suppliers");
    }

}
