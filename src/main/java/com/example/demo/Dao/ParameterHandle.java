package com.example.demo.Dao;

import com.example.demo.Entity.CassHerder;
import com.example.demo.Entity.CassParameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterHandle {

    public Map<String, String> getParameter(List<CassParameter> ParameterList){

        Map<String, String> ParameterMap = new HashMap<String, String>();
        if (ParameterList.size()!=0){
            for (CassParameter c : ParameterList) {
                ParameterMap.put(c.getPname(), c.getPparamter());
            }
        }
        return ParameterMap;
    }






}
