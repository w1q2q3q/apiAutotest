package com.example.demo.Dao;

import com.example.demo.Entity.AssertDate;
import com.example.demo.Entity.CassAssert;
import com.example.demo.Entity.CassReport;
import com.example.demo.Entity.TestCass;
import io.restassured.response.Response;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
@Repository
public class TestCassDao {

    public  CassReport runcass(TestCass testCass) {
        // Cookie cookie = new Cookie.Builder("name", "value").setComment("some
        // comment").setExpiryDate(someDate).build();
//      RequestSpecification requestSpec = new RequestSpecBuilder().addParam("parameter1", "value1").build();
        HerderHandle herderHandle = new HerderHandle();
        CookieHandle cookiesHandle = new CookieHandle();
        ParameterHandle parameterHandle = new ParameterHandle();
        CassReport cassReport = new CassReport();
        AssertMatchDao assertMatchDao = new AssertMatchDao();
        Response response =null;
        if (testCass.getMethod()== 0){
            if(testCass.getHerder()==1) {
                if (testCass.getCookies()==1) {
                    response = given()
                            .headers(herderHandle.getHerder(testCass.getHerderList()))
                            .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .post(testCass.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .headers(herderHandle.getHerder(testCass.getHerderList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .post(testCass.getUrl());// 发起get请求，并获取响应
                }
            }else {
                if (testCass.getCookies()==1) {
                    response = given()
                            .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .post(testCass.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .post(testCass.getUrl());// 发起get请求，并获取响应
                }
            }
        }else {
            if(testCass.getHerder()==1) {
                if (testCass.getCookies()==1) {
                    response = given()
                            .headers(herderHandle.getHerder(testCass.getHerderList()))
                            .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .get(testCass.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .headers(herderHandle.getHerder(testCass.getHerderList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .get(testCass.getUrl());// 发起get请求，并获取响应
                }
            }else {
                if (testCass.getCookies()==1) {
                    response = given()
                            .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .get(testCass.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .params(parameterHandle.getParameter(testCass.getParameterList()))
                            .when()
                            .get(testCass.getUrl());// 发起get请求，并获取响应
                }
            }
        }
        List<AssertDate> assertList = new ArrayList<AssertDate>();
        if(testCass.getCassAssert()==1){
            for (CassAssert cassAssert : testCass.getAssertList()){
                if (cassAssert.getResponsetype()==0){

                     assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),response.getBody().asString(),cassAssert.getAssertmethod());

                }else if(cassAssert.getResponsetype()==1){

                    assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),response.getBody().asString(),cassAssert.getAssertmethod());

                }else if(cassAssert.getResponsetype()==2){

                    assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),response.getBody().asString(),cassAssert.getAssertmethod());

                }else{

                }

            }
        }
        cassReport.setCassid(testCass.getId());
        cassReport.setCode(response.getStatusCode());
        cassReport.setCassrequest(response.getBody().asString());
//   String json = get("http://dev.meiningjia.com/v4/image/null").asString();
        return cassReport;
    }


















    public static void main(String[] args) {
        TestCass testCass = null;
        //TestCassDao.runcass(testCass);
    }
}
