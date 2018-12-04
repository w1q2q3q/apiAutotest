package com.example.demo.Mapper;

import com.example.demo.Entity.CaseHerder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseHerderMapper {

    public void addHerder(List<CaseHerder> CaseHerder);

}
