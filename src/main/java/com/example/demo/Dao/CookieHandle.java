package com.example.demo.Dao;

import com.example.demo.Entity.CaseCookies;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

import java.util.ArrayList;
import java.util.List;

public class CookieHandle {

    public Cookies getCookie(List<CaseCookies> CookiesList){
        //Cookies cookiess=null;
        List<Cookie> cookieList = new ArrayList<Cookie>();
        if(CookiesList.size()!=0) {
            for (CaseCookies cc : CookiesList) {
                Cookie cookie = new Cookie.Builder(cc.getCname(), cc.getCparamter()).build();
                cookieList.add(cookie);
            }
           // cookiess = (Cookies) cookieList;
        }
        return new Cookies(cookieList);
    }






}
