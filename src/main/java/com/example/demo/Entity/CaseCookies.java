package com.example.demo.Entity;

import lombok.Data;

@Data
public class CaseCookies {
    int cid;
    String cname;
    String cparamter;
    int ccaseid;
    TestCase testCase;
}
