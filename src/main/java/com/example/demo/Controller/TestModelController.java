package com.example.demo.Controller;

import com.example.demo.Entity.TestModel;
import com.example.demo.Service.TestModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/TestModel")
public class TestModelController {
    @Autowired
    private TestModelService testModelService;


    @RequestMapping(value = "/addModel",method = RequestMethod.POST)
    public void addModel(@RequestBody TestModel testModel){
        testModelService.addModel(testModel);
    }

    @RequestMapping(value = "/getModel/{projectid}",method = RequestMethod.GET)
    public List<TestModel> getModel(@PathVariable(name="projectid") int projectid){
        return testModelService.getModel(projectid);
    }
}
