package com.example.demo.Service;

import com.example.demo.Dao.TestCaseDao;
import com.example.demo.Entity.*;
import com.example.demo.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService {
    @Autowired
     private TestCaseMapper TestCaseMapper;
    @Autowired
     private CaseHerderMapper CaseHerderMapper;
    @Autowired
     private CaseParameterMapper CaseParameterMapper;
    @Autowired
     private CaseAssertMapper CaseAssertMapper;
    @Autowired
     private CaseCookiesMapper CaseCookiesMapper;
    @Autowired
     private TestCaseDao testCaseDao;

    public void addCase(TestCase TestCase){
        TestCaseMapper.addCase(TestCase);
        if (TestCase.getHerderList().size()!=0) {
            List<CaseHerder> cl = TestCase.getHerderList();
            for (CaseHerder ch : cl) {
                ch.setHcaseid(TestCase.getId());
            }
            CaseHerderMapper.addHerder(cl);
        }
        if(TestCase.getParameterList().size()!=0){
            List<CaseParameter> cp= TestCase.getParameterList();
            for(CaseParameter ch : cp){
                ch.setPcaseid(TestCase.getId());
            }
            CaseParameterMapper.addParameter(cp);
        }
        if(TestCase.getAssertList().size()!=0) {
            List<CaseAssert> ca = TestCase.getAssertList();
            for (CaseAssert ch : ca) {
                ch.setAcaseid(TestCase.getId());
            }
            CaseAssertMapper.addAssert(ca);
        }
        if(TestCase.getCookiesList().size()!=0) {
            List<CaseCookies> ca = TestCase.getCookiesList();
            for (CaseCookies cc : ca) {
                cc.setCcaseid(TestCase.getId());
            }
            CaseCookiesMapper.addCookies(ca);
        }
    }

    public List<TestCase> getCaseList(){

        return TestCaseMapper.getCaseList();

    }

    public TestCase getCase(int id){
        return TestCaseMapper.getCase(id);
    }

    public CaseReport runCase(TestCase testCase){

        return testCaseDao.runcase(testCase);
    }

    public List<TestCase> getCaseListByCaseModel(int casemodel){
        return TestCaseMapper.getCaseListByCaseModel(casemodel);
    }
}
