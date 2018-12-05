package com.example.demo.Mapper;

import com.example.demo.Entity.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestModelMapper {
    public void addModel(TestModel testModel);
    public List<TestModel> getModel(int projectid);



}
