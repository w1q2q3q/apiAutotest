package com.example.demo.Entity;

import lombok.Data;

@Data
public class CassAssert {
    int aid;
    private int responsetype;
    private String assertparameter;
    private int assertmethod;
//    private String responsedate;
    int acassid;
    TestCass testCass;
}
