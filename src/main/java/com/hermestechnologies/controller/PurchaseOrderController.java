package com.hermestechnologies.controller;

import com.hermestechnologies.domain.Po;
import com.hermestechnologies.service.PurchaseOrder.PoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory/")
public class PurchaseOrderController {

    @Autowired
    PoService poService;

    @GetMapping("po/{id}")
    public String getPurchaseOrder(@PathVariable Integer id, Model model){
        Po po = poService.getPo(id);
        model.addAttribute("po",po);
        return "purchase-order";
    }

}
