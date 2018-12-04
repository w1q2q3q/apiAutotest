package com.example.demo.Mapper;

import com.example.demo.Entity.TestCase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestCaseMapper {

  public void addCase(TestCase TestCase);

  public List<TestCase> getCaseList();

  public TestCase getCase(int id);
}
