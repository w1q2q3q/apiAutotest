package com.example.demo.Service;

import com.example.demo.Entity.TestCase;
import com.example.demo.Entity.TestModel;
import com.example.demo.Mapper.TestModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestModelService {
    @Autowired
    private TestModelMapper testModelMapper;

    public List<TestModel> getModel(int projectid){
        return testModelMapper.getModel(projectid);
    }

    public void addModel(TestModel testModel){
        testModelMapper.addModel(testModel);
    }

    public List<TestModel> getAllModel(){
        return testModelMapper.getAllModel();
    }


}
