package com.hermestechnologies.controller;

import com.hermestechnologies.domain.PoItem;
import com.hermestechnologies.domain.Product;
import com.hermestechnologies.domain.SupplierProduct;
import com.hermestechnologies.service.PoItem.PoItemService;
import com.hermestechnologies.service.Product.ProductService;
import com.hermestechnologies.service.SupplierProducts.SupplierProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class StocksController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierProductService supplierProductService;
    @Autowired
    PoItemService poItemService;

    @GetMapping("/inventory/products/stocks/{productId}")
    public String productStocks(@PathVariable Integer productId, Model model){
        Product product = productService.getProduct(productId);
        List<SupplierProduct> suppliers = supplierProductService.getSuppliers(productId);

        model.addAttribute("productName", product.getGeneric_name()+" "+product.getDosage()+" ("+product.getBrand_name()+")");
        model.addAttribute("stocks",product.getStocks());
        model.addAttribute("product",product);
        model.addAttribute("suppliers",suppliers);
        model.addAttribute("poItem",new PoItem());
        return "stocks";
    }

    @PostMapping("/inventory/products/stocks/{productId}")
    public ModelAndView AddToPoQueue(@PathVariable Integer productId, Model model, @ModelAttribute PoItem poItem,
                                     ModelAndView modelAndView, RedirectAttributes redir){
        Product product = productService.getProduct(productId);
        poItem.setProduct(product);
        poItemService.save(poItem);
        modelAndView.setViewName("redirect:/inventory/products/stocks/"+productId);
        redir.addFlashAttribute("noty","added");
        return modelAndView;
    }


}
