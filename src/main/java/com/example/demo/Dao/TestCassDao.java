package com.example.demo.Dao;

import com.example.demo.Entity.CassReport;
import com.example.demo.Entity.TestCass;
import io.restassured.response.Response;
import org.springframework.stereotype.Repository;

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
        ParameterHandle parameterHandle =new ParameterHandle();
        CassReport cassReport = new CassReport();
        Response response =null;
        if (testCass.getMethod()== 0){
            response = given()
                    .headers(herderHandle.getHerder(testCass.getHerderList()))
                    .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                    .params(parameterHandle.getParameter(testCass.getParameterList()))
                    .when()
                    .post(testCass.getUrl());// 发起get请求，并获取响应
        }else {
            response = given()
                    .headers(herderHandle.getHerder(testCass.getHerderList()))
                    .cookies(cookiesHandle.getCookie(testCass.getCookiesList()))
                    .params(parameterHandle.getParameter(testCass.getParameterList()))
                    .when()
                    .get(testCass.getUrl());// 发起get请求，并获取响应
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
