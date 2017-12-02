package com.hermestechnologies.service.PoItem;

import com.hermestechnologies.domain.PoItem;

import java.util.List;

public interface PoItemDao {

    void save(PoItem poItem);
    List getQueued();

}
