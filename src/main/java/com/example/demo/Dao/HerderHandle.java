package com.example.demo.Dao;

import com.example.demo.Entity.CaseHerder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HerderHandle {

    public Map<String, String> getHerder(List<CaseHerder> caseHerderList){
        Map<String, String> headers = new HashMap<String, String>();
        if (caseHerderList.size()!=0){
            for (CaseHerder c : caseHerderList) {
                headers.put(c.getHname(), c.getHparamter());
            }
        }
        return headers;
    }
}
