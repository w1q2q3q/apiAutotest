package com.example.demo.Mapper;

import com.example.demo.Entity.TestCass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestCassMapper {

  public void addCass(TestCass TestCass);


}
