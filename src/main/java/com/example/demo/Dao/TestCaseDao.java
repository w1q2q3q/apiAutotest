package com.example.demo.Dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.Entity.AssertDate;
import com.example.demo.Entity.CaseAssert;
import com.example.demo.Entity.CaseReport;
import com.example.demo.Entity.TestCase;
import com.example.demo.Mapper.TestCaseMapper;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
@Repository
public class TestCaseDao {
    @Autowired
    private TestCaseMapper testCaseMapper;

    public CaseReport runcase(TestCase testCase) {
        // Cookie cookie = new Cookie.Builder("name", "value").setComment("some
        // comment").setExpiryDate(someDate).build();
//      RequestSpecification requestSpec = new RequestSpecBuilder().addParam("parameter1", "value1").build();
        int state=1;
        HerderHandle herderHandle = new HerderHandle();
        CookieHandle cookiesHandle = new CookieHandle();
        ParameterHandle parameterHandle = new ParameterHandle();
        CaseReport caseReport = new CaseReport();
        AssertMatchDao assertMatchDao = new AssertMatchDao();
        Response response =null;
        if (testCase.getMethod()== 0){
            if(testCase.getHerder()==1) {
                if (testCase.getCookies()==1) {
                    response = given()
                            .headers(herderHandle.getHerder(testCase.getHerderList()))
                            .cookies(cookiesHandle.getCookie(testCase.getCookiesList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .post(testCase.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .headers(herderHandle.getHerder(testCase.getHerderList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .post(testCase.getUrl());// 发起get请求，并获取响应
                }
            }else {
                if (testCase.getCookies()==1) {
                    response = given()
                            .cookies(cookiesHandle.getCookie(testCase.getCookiesList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .post(testCase.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .post(testCase.getUrl());// 发起get请求，并获取响应
                }
            }
        }else {
            if(testCase.getHerder()==1) {
                if (testCase.getCookies()==1) {
                    response = given()
                            .headers(herderHandle.getHerder(testCase.getHerderList()))
                            .cookies(cookiesHandle.getCookie(testCase.getCookiesList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .get(testCase.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .headers(herderHandle.getHerder(testCase.getHerderList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .get(testCase.getUrl());// 发起get请求，并获取响应
                }
            }else {
                if (testCase.getCookies()==1) {
                    response = given()
                            .cookies(cookiesHandle.getCookie(testCase.getCookiesList()))
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .get(testCase.getUrl());// 发起get请求，并获取响应
                }else {
                    response = given()
                            .params(parameterHandle.getParameter(testCase.getParameterList()))
                            .when()
                            .get(testCase.getUrl());// 发起get请求，并获取响应
                }
            }
        }
        List<AssertDate> assertList = new ArrayList<AssertDate>();
        if(testCase.getCaseAssert()==1){
            for (CaseAssert caseAssert : testCase.getAssertList()){
                AssertDate assertDate = new AssertDate();
                assertDate.setResponsetype(caseAssert.getResponsetype());
                assertDate.setAssertparameter(caseAssert.getAssertparameter());
                assertDate.setAssertmethod(caseAssert.getAssertmethod());
                assertDate.setResult(0);
                if (caseAssert.getResponsetype()==0){
                    try {
                        assertDate.setResponse(response.getBody().asString());
                        Object object = JSON.parse(response.getBody().asString());
                        if (object instanceof JSONObject) {
                            //JSONObject jsonObject = (JSONObject) response.getBody();
                            JSONObject Body = (JSONObject) JSON.parse(response.getBody().asString());
                            JSONObject Assertparameter = (JSONObject) JSON.parse(caseAssert.getAssertparameter());
                            String result = assertMatchDao.ValueMatch(Assertparameter.toJSONString(), Body.toJSONString(), 0);
                            if (result.equals("1")) {
                                assertDate.setResult(1);
                            } else {
                                assertDate.setResult(2);
                                state = 2;
                            }
                            assertDate.setAssertresult(result);
                        } else if (object instanceof JSONArray) {
                            JSONArray Body = (JSONArray) JSON.parse(response.getBody().asString());
                            JSONArray Assertparameter = (JSONArray) JSON.parse(caseAssert.getAssertparameter());
                            String result = assertMatchDao.ValueMatch(Assertparameter.toJSONString(), Body.toJSONString(), 0);
                            if (result.equals("1")) {
                                assertDate.setResult(1);
                            } else {
                                assertDate.setResult(2);
                                state = 2;
                            }
                            assertDate.setAssertresult(result);
                        } else {
                            state = 2;
                            assertDate.setResult(3);
                            assertDate.setAssertresult("Json无法被解析");
                            System.out.println("Json无法被解析");
                        }
                    }catch (Exception e){
                        assertDate.setResult(3);
                        assertDate.setAssertresult("Json无法被解析");
                    }
                  //   assertMatchDao.ValueMatch(caseAssert.getAssertparameter(),response.getBody().asString(),caseAssert.getAssertmethod());
                }else if(caseAssert.getResponsetype()==1){
                    assertDate.setResponse(response.getBody().asString());
                    String result=assertMatchDao.ValueMatch(caseAssert.getAssertparameter(),response.getBody().asString(), caseAssert.getAssertmethod());
                    if (result.equals("1")){
                        assertDate.setResult(1);
                    }else{
                        assertDate.setResult(2);
                        state=2;
                    }
                    assertDate.setAssertresult(result);
                }else if(caseAssert.getResponsetype()==2){
                    assertDate.setResponse(String.valueOf(response.getStatusCode()));
                    String result= assertMatchDao.ValueMatch(caseAssert.getAssertparameter(),String.valueOf(response.getStatusCode()), caseAssert.getAssertmethod());
                    if (result.equals("1")){
                        assertDate.setResult(1);
                    }else{
                        assertDate.setResult(2);
                        state=2;
                    }
                    assertDate.setAssertresult(result);
                }else{
                    state=2;
                    assertDate.setResult(3);
                }
                assertList.add(assertDate);
            }
        }
        caseReport.setCaseid(testCase.getId());
        caseReport.setCode(response.getStatusCode());
        caseReport.setCaserequest(response.getBody().asString());
        caseReport.setAssertList(assertList);
//   String json = get("http://dev.meiningjia.com/v4/image/null").asString();
        testCaseMapper.runCasestate(state,testCase.getId());
        return caseReport;
    }

    public static void main(String[] args) {
        TestCase testCase = null;
        //TestCaseDao.runcase(testCase);
    }
}
