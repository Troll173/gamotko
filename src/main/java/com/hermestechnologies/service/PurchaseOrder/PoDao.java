package com.hermestechnologies.service.PurchaseOrder;

import com.hermestechnologies.domain.Po;

import java.util.List;

public interface PoDao {

    Po getPo(Integer id);
    List<Po> getPos();

}
