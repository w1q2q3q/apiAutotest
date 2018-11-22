package com.example.demo.Mapper;

import com.example.demo.Entity.CassAssert;
import com.example.demo.Entity.CassCookies;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CassCookiesMapper {

    public void addCookies(List<CassCookies> CookiesList);

}
