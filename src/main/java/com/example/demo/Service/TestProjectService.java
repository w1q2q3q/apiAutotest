package com.example.demo.Service;

import com.example.demo.Entity.TestProject;
import com.example.demo.Mapper.TestProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestProjectService {
    @Autowired
    private TestProjectMapper testProjectMapper;

    public void addProject(TestProject testProject){
        testProjectMapper.addProject(testProject);
    }

    public List<TestProject> getAllProject(){
       return testProjectMapper.getAllProject();
    }
}
