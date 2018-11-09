package com.example.demo.Mapper;

import com.example.demo.Entity.CassParameter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CassParameterMapper {

    public void addParameter(List<CassParameter> CassParameter);


}
