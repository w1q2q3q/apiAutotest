package com.example.demo.Mapper;

import com.example.demo.Entity.CaseAssert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseAssertMapper {

    public void addAssert(List<CaseAssert> CaseAssert);

}
