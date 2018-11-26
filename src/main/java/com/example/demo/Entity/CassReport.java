package com.example.demo.Entity;

import lombok.Data;

import java.util.List;

@Data
public class CassReport {
    int id;
    int code;
    int cassid;
    String Cassrequest;
    List<AssertDate> AssertList;
}
