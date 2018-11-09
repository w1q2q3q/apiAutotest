package com.example.demo.Controller;

import com.example.demo.Entity.TestCass;
import com.example.demo.Mapper.TestCassMapper;
import com.example.demo.Service.TestCassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TestCass")
public class TestCassController {
    @Autowired
    private TestCassService TestCassService;


    @RequestMapping(value = "/addCass",method = RequestMethod.POST)
    public void addCass(@RequestBody TestCass testCass){
        System.out.println(testCass);
        TestCassService .addCass(testCass);
        System.out.println("csss");
        System.out.println("sscss");
    }







}
