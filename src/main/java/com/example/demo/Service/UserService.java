package com.example.demo.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

     public List<Person>  selectAllUser(){
         return userMapper.selectAllUser();
     }


}
