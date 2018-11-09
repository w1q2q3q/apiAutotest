package com.example.demo.Mapper;

import com.example.demo.Entity.CassHerder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CassHerderMapper {

    public void addHerder(List<CassHerder> CassHerder);

}
