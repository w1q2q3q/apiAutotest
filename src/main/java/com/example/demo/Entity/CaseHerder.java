package com.example.demo.Entity;

import lombok.Data;

@Data
public class CaseHerder {
    int hid;
    String hname;
    String hparamter;
    int hcaseid;
    TestCase testCase;
}
