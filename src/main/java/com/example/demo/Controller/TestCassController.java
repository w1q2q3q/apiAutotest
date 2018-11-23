package com.example.demo.Controller;

import com.example.demo.Entity.CassReport;
import com.example.demo.Entity.TestCass;
import com.example.demo.Service.TestCassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TestCass")
public class TestCassController {
    @Autowired
    private TestCassService TestCassService;

    @RequestMapping(value = "/getCassList",method = RequestMethod.GET)
    public List<TestCass> getCassList() {
//        System.out.println(TestCassService.getCassList());
       return TestCassService.getCassList();
    }
    @RequestMapping(value = "/addCass",method = RequestMethod.POST)
    public void addCass(@RequestBody TestCass testCass){
        System.out.println(testCass);
        TestCassService .addCass(testCass);
        System.out.println("csss");
        System.out.println("sscss");
    }

    @RequestMapping(value ="/runCass",method = RequestMethod.POST)
    public CassReport runCass(@RequestBody TestCass testCass){

        return TestCassService.runCass(testCass);
    }

    @RequestMapping(value ="/editCass/{id}",method = RequestMethod.GET)
    public TestCass editCass(@PathVariable(name = "id") int id){

        return TestCassService.getCass(id);
    }





}
