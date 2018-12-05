package com.example.demo.Controller;

import com.example.demo.Entity.TestProject;
import com.example.demo.Service.TestProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TestProject")
public class TestProjectController {
    @Autowired
    private TestProjectService testProjectService;

    @RequestMapping(value = "/addProject",method = RequestMethod.POST)
    public void addProject(@RequestBody TestProject testProject){
        testProjectService.addProject(testProject);
    }
    @RequestMapping(value = "/getAllProject",method = RequestMethod.GET)
    public List<TestProject> getAllProject(){
        return testProjectService.getAllProject();
    }




}
