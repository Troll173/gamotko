package com.hermestechnologies.controller;

import com.hermestechnologies.domain.Product;
import com.hermestechnologies.service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class ProductsController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public String productList(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);
        model.addAttribute("product", new Product());
        System.out.println(products);
        return "product-list";
    }

    @PostMapping("/products")
    public ModelAndView addProduct(@ModelAttribute Product product, Model model){
        System.out.println(product);
        model.addAttribute("product", new Product());
        productService.save(product);
        return new ModelAndView("redirect:/inventory/products");
    }


}
