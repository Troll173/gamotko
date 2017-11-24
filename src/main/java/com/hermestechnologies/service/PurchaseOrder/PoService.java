package com.hermestechnologies.service.PurchaseOrder;

import com.hermestechnologies.domain.Po;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PoService {

    @Autowired
    PoDao poDao;

    @Transactional
    public Po getPo(Integer id){
        return poDao.getPo(id);
    }

}
