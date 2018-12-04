package com.example.demo.Mapper;

import com.example.demo.Entity.CaseCookies;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CaseCookiesMapper {

    public void addCookies(List<CaseCookies> CookiesList);

}
