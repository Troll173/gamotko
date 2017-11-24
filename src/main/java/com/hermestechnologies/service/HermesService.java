package com.hermestechnologies.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class HermesService {

    public List<List> toArray(List list){
        List<List> res = new ArrayList<List>();
        for (Object obj : list) {
            Class<?> objClass = obj.getClass();

            Field[] fields = objClass.getFields();
            List vals = new ArrayList();
            Integer index = 0;
            for(Field field : fields) {
                String name = field.getName();
                try {
                    fields[index].setAccessible(true);
                    Object value = fields[index].get(name);
                    System.out.println(value);
                    vals.add(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    vals.add("");
                }
                index++;
            }
            res.add(vals);
        }
        return res;
    }

}
