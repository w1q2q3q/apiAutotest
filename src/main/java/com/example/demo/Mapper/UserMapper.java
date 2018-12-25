package com.example.demo.Mapper;

import com.example.demo.Entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM person")
    List<Person> selectAllUser();


}
