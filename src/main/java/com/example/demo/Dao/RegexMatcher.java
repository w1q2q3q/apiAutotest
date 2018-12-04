package com.example.demo.Dao;

import org.hamcrest.*;

public class RegexMatcher extends TypeSafeMatcher<String> {
    private final String regex;
    private int state;

    public RegexMatcher(final String regex) {
        this.regex = regex;
    }
    protected boolean matchesSafely(String item) {
        if (item==""){
            state=0;
            return false;
        }
        state=1;
        return item.matches(regex);
    }
    public void describeTo(Description description) {
        if (state==0){
            description.appendText("The parameter is empty,matches regular expression=`" + regex + "`");
        }else{
            description.appendText("matches regular expression=`" + regex + "`");
        }
    }

    public static RegexMatcher matchesRegex(final String regex) {
        return new RegexMatcher(regex);
    }
}