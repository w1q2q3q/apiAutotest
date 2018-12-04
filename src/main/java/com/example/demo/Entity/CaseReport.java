package com.example.demo.Entity;

import lombok.Data;

import java.util.List;

@Data
public class CaseReport {
    int id;
    int code;
    int caseid;
    String Caserequest;
    List<AssertDate> AssertList;
}
