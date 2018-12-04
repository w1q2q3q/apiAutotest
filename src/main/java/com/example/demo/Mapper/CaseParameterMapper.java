package com.example.demo.Mapper;

import com.example.demo.Entity.CaseParameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseParameterMapper {

    public void addParameter(List<CaseParameter> CaseParameter);


}
