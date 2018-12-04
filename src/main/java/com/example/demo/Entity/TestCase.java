package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class TestCase {
    private int id;
    @JsonProperty(value = "Casename")
    private String casename;
    @JsonProperty(value = "Casedescribe")
    private String casedescribe;
    @JsonProperty(value = "Casemodel")
    private int casemodel;
    @JsonProperty(value = "Url")
    private String url;
    @JsonProperty(value = "Method")
    private int method;
    @JsonProperty(value = "Herder")
    private int herder;
    @JsonProperty(value = "HerderList")
    private List<CaseHerder> herderList;
    @JsonProperty(value = "Cookies")
    private int cookies;
    @JsonProperty(value ="CookiesList")
    private List<CaseCookies> cookiesList;
    @JsonProperty(value = "Parameter")
    private int parameter;
    @JsonProperty(value = "ParameterList")
    private List<CaseParameter> parameterList;
    @JsonProperty(value = "CaseAssert")
    private int caseAssert;
    @JsonProperty(value = "AssertList")
    private List<CaseAssert> assertList;
    @JsonProperty(value = "state")
    private int state;
}
