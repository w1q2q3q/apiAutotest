package com.example.demo.Service;

import com.example.demo.Dao.TestCassDao;
import com.example.demo.Entity.*;
import com.example.demo.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
     private CassCookiesMapper CassCookiesMapper;
    @Autowired
     private TestCassDao testCassDao;

    public void addCass(TestCass TestCass){
        TestCassMapper.addCass(TestCass);
        if (TestCass.getHerderList().size()!=0) {
            List<CassHerder> cl = TestCass.getHerderList();
            for (CassHerder ch : cl) {
                ch.setHcassid(TestCass.getId());
            }
            CassHerderMapper.addHerder(cl);
        }
        if(TestCass.getParameterList().size()!=0){
            List<CassParameter> cp=TestCass.getParameterList();
            for(CassParameter ch : cp){
                ch.setPcassid(TestCass.getId());
            }
            CassParameterMapper.addParameter(cp);
        }
        if(TestCass.getAssertList().size()!=0) {
            List<CassAssert> ca = TestCass.getAssertList();
            for (CassAssert ch : ca) {
                ch.setAcassid(TestCass.getId());
            }
            CassAssertMapper.addAssert(ca);
        }
        if(TestCass.getCookiesList().size()!=0) {
            List<CassCookies> ca = TestCass.getCookiesList();
            for (CassCookies cc : ca) {
                cc.setCcassid(TestCass.getId());
            }
            CassCookiesMapper.addCookies(ca);
        }
    }

    public List<TestCass> getCassList(){

        return TestCassMapper.getCassList();

    }

    public CassReport runCass(TestCass testCass){

        return testCassDao.runcass(testCass);
    }
}
