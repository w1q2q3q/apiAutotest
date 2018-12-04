package com.example.demo.Dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
                AssertDate assertDate = new AssertDate();
                assertDate.setResponsetype(cassAssert.getResponsetype());
                assertDate.setAssertparameter(cassAssert.getAssertparameter());
                assertDate.setAssertmethod(cassAssert.getAssertmethod());
                assertDate.setResult(0);
                if (cassAssert.getResponsetype()==0){
                    assertDate.setResponse(response.getBody().asString());
                    Object object = JSON.parse(response.getBody().asString());
                    if (object instanceof JSONObject) {
                        //JSONObject jsonObject = (JSONObject) response.getBody();
                        JSONObject Body = (JSONObject) JSON.parse(response.getBody().asString());
                        JSONObject Assertparameter = (JSONObject)JSON.parse(cassAssert.getAssertparameter());
                        String result = assertMatchDao.ValueMatch(Assertparameter.toJSONString(),Body.toJSONString(),0);
                        if (result.equals("1")){
                            assertDate.setResult(1);
                        }
                        assertDate.setAssertresult(result);
                    } else if (object instanceof JSONArray) {
                        JSONArray Body = (JSONArray) JSON.parse(response.getBody().asString());
                        JSONArray Assertparameter = (JSONArray)JSON.parse(cassAssert.getAssertparameter());
                        String result =  assertMatchDao.ValueMatch(Assertparameter.toJSONString(),Body.toJSONString(),0);
                        if (result.equals("1")){
                            assertDate.setResult(1);
                        }
                        assertDate.setAssertresult(result);
                    } else {
                        assertDate.setResult(3);
                        assertDate.setAssertresult("Json无法被解析");
                        System.out.println("Json无法被解析");
                    }
                  //   assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),response.getBody().asString(),cassAssert.getAssertmethod());
                }else if(cassAssert.getResponsetype()==1){
                    assertDate.setResponse(response.getBody().asString());
                    String result=assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),response.getBody().asString(),cassAssert.getAssertmethod());
                    if (result.equals("1")){
                        assertDate.setResult(1);
                    }
                    assertDate.setAssertresult(result);
                }else if(cassAssert.getResponsetype()==2){
                    assertDate.setResponse(String.valueOf(response.getStatusCode()));
                    String result= assertMatchDao.ValueMatch(cassAssert.getAssertparameter(),String.valueOf(response.getStatusCode()),cassAssert.getAssertmethod());
                    if (result.equals("1")){
                        assertDate.setResult(1);
                    }
                    assertDate.setAssertresult(result);
                }else{
                    assertDate.setResult(3);
                }
                assertList.add(assertDate);
            }
        }
        cassReport.setCassid(testCass.getId());
        cassReport.setCode(response.getStatusCode());
        cassReport.setCassrequest(response.getBody().asString());
        cassReport.setAssertList(assertList);
//   String json = get("http://dev.meiningjia.com/v4/image/null").asString();
        return cassReport;
    }

    public static void main(String[] args) {
        TestCass testCass = null;
        //TestCassDao.runcass(testCass);
    }
}
