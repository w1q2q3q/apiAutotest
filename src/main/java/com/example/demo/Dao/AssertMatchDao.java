package com.example.demo.Dao;

import static org.hamcrest.MatcherAssert.assertThat;

public class AssertMatchDao {

    public String ValueMatch(String Assertparameter, String responsedate, int method){
        try{
            switch (method) {
                case 1:
                    assertThat("", equals(""));
                    return "成功";
                case 2:
                    return "成功";
                case 3:
                    return "成功";
            }
        }catch (AssertionError e){
            return e.toString();
        }
        return "";
    }
}
