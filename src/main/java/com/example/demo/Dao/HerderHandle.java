package com.example.demo.Dao;

import com.example.demo.Entity.CassHerder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HerderHandle {

    public Map<String, String> getHerder(List<CassHerder> CassHerderList){
        Map<String, String> headers = new HashMap<String, String>();
        if (CassHerderList.size()!=0){
            for (CassHerder c : CassHerderList) {
                headers.put(c.getHname(), c.getHparamter());
            }
        }
        return headers;
    }
}
