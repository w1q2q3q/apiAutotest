package com.example.demo.Mapper;

import com.example.demo.Entity.TestProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestProjectMapper{
    public void addProject(TestProject testProject);
    public List<TestProject> getAllProject();
}
