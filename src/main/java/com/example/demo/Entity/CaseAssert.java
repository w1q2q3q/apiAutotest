package com.example.demo.Entity;

import lombok.Data;

@Data
public class CaseAssert {
    int aid;
    private int responsetype;
    private String assertparameter;
    private int assertmethod;
//    private String responsedate;
    int acaseid;
    TestCase testCase;
}
