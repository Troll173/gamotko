package com.hermestechnologies.controller;

import com.hermestechnologies.domain.Po;
import com.hermestechnologies.domain.PoItem;
import com.hermestechnologies.domain.Supplier;
import com.hermestechnologies.service.PoItem.PoItemService;
import com.hermestechnologies.service.PurchaseOrder.PoService;
import com.hermestechnologies.service.Supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/inventory/")
public class PurchaseOrderController {

    @Autowired
    PoService poService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    PoItemService poItemService;

    @GetMapping("po/{id}")
    public String getPurchaseOrder(@PathVariable Integer id, Model model){
        Po po = poService.getPo(id);
        model.addAttribute("po",po);
        System.out.println(po);
        return "purchase-order";
    }


    @GetMapping("po")
    public String getPos(Model model){
        List<Po> pos = poService.getPurchaseOrders();
        model.addAttribute("pos",pos);
        return "purchase_orders";
    }

    @GetMapping("new/po")
    public String createPo(Model model){
        List<Supplier> supplierList = supplierService.getSupplierList();
        List<HashMap<String, Object>> queuedList = poItemService.getQueuedItems(supplierList);
        model.addAttribute("supplierList",supplierList);
        model.addAttribute("queuedList",queuedList);
        return "newPo";
    }

}
