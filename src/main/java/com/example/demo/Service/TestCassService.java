package com.example.demo.Service;

import com.example.demo.Entity.CassAssert;
import com.example.demo.Entity.CassHerder;
import com.example.demo.Entity.CassParameter;
import com.example.demo.Entity.TestCass;
import com.example.demo.Mapper.CassAssertMapper;
import com.example.demo.Mapper.CassHerderMapper;
import com.example.demo.Mapper.CassParameterMapper;
import com.example.demo.Mapper.TestCassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestCassService {
    @Autowired
     private TestCassMapper TestCassMapper;
    @Autowired
     private CassHerderMapper CassHerderMapper;
    @Autowired
     private CassParameterMapper CassParameterMapper;
    @Autowired
     private CassAssertMapper CassAssertMapper;

    public void addCass(TestCass TestCass){
        TestCassMapper.addCass(TestCass);
        List<CassHerder> cl=TestCass.getHerderList();
        for(CassHerder ch : cl){
         ch.setCassid(TestCass.getId());
        }
        List<CassParameter> cp=TestCass.getParameterList();
        for(CassParameter ch : cp){
            ch.setCassid(TestCass.getId());
        }
        List<CassAssert> ca=TestCass.getAssertList();
        for(CassAssert ch : ca){
            ch.setCassid(TestCass.getId());
        }
        CassHerderMapper.addHerder(cl);
        CassParameterMapper.addParameter(cp);
        CassAssertMapper.addAssert(ca);
 }
}