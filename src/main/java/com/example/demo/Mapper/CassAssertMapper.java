package com.example.demo.Mapper;

import com.example.demo.Entity.CassAssert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CassAssertMapper {

    public void addAssert(List<CassAssert> CassAssert);

}
