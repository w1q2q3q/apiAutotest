package com.example.demo.Dao;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertMatchDao {

    public String ValueMatch(String Assertparameter, String responsedate, int method){
        try{
            switch (method) {
                case 0:
                    assertThat(Assertparameter,equalTo(responsedate));
                    System.out.println(Assertparameter+"和"+responsedate);
                    return "1";
                case 1:
                    assertThat(responsedate,containsString(Assertparameter));
                    return "1";
                case 2:
                    assertThat(responsedate,RegexMatcher.matchesRegex(Assertparameter));
                    return "1";
            }
        }catch (AssertionError e){
            return e.toString();
        }
        return "";
    }
}
