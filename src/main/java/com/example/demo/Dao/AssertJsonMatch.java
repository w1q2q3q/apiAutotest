package com.example.demo.Dao;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class AssertJsonMatch extends TypeSafeMatcher<String> {
    public final String json;

    public AssertJsonMatch(String json) {
        this.json = json;
    }

    @Override
    protected boolean matchesSafely(String item) {
        return false;
    }

    @Override
    public void describeTo(Description description) {
          description.appendText("");
    }

    public static AssertJsonMatch jsonMatch(final String json){
        return new AssertJsonMatch(json);
    }
}
