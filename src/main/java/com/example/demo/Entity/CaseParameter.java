package com.example.demo.Entity;

import lombok.Data;

@Data
public class CaseParameter {
    int pid;
    String pname;
    String pparamter;
    int pcaseid;
    TestCase testCase;
}
