package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class TestCass {
    private int id;
    @JsonProperty(value = "Cassname")
    private String cassname;
    @JsonProperty(value = "Cassdescribe")
    private String cassdescribe;
    @JsonProperty(value = "Cassmodel")
    private int cassmodel;
    @JsonProperty(value = "Url")
    private String url;
    @JsonProperty(value = "Method")
    private int method;
    @JsonProperty(value = "Herder")
    private int herder;
    @JsonProperty(value = "HerderList")
    private List<CassHerder> herderList;
    @JsonProperty(value = "Parameter")
    private int parameter;
    @JsonProperty(value = "ParameterList")
    private List<CassParameter> parameterList;
    @JsonProperty(value = "CassAssertMapper")
    private int cassAssert;
    @JsonProperty(value = "AssertList")
    private List<CassAssert> assertList;
}
