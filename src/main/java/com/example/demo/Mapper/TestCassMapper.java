package com.example.demo.Mapper;

import com.example.demo.Entity.TestCass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestCassMapper {

  public void addCass(TestCass TestCass);

  public List<TestCass> getCassList();

  public TestCass getCass(int id);
}
