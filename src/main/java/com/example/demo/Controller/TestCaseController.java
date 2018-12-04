package com.example.demo.Controller;

import com.example.demo.Entity.CaseReport;
import com.example.demo.Entity.TestCase;
import com.example.demo.Service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TestCase")
public class TestCaseController {
    @Autowired
    private TestCaseService TestCaseService;

    @RequestMapping(value = "/getCaseList",method = RequestMethod.GET)
    public List<TestCase> getCaseList() {
//        System.out.println(TestCaseService.getCaseList());
       return TestCaseService.getCaseList();
    }
    @RequestMapping(value = "/addCase",method = RequestMethod.POST)
    public void addCase(@RequestBody TestCase testCase){
        System.out.println(testCase);
        TestCaseService.addCase(testCase);
        System.out.println("csss");
        System.out.println("sscss");
    }

    @RequestMapping(value ="/runCase",method = RequestMethod.POST)
    public CaseReport runCase(@RequestBody TestCase testCase){

        return TestCaseService.runCase(testCase);
    }

    @RequestMapping(value ="/editCase/{id}",method = RequestMethod.GET)
    public TestCase editCase(@PathVariable(name = "id") int id){

        return TestCaseService.getCase(id);
    }





}
