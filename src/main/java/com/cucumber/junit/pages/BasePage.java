package com.cucumber.junit.pages;

import java.util.HashMap;
import java.util.Map;

public class BasePage {

    private static final Map<String, String> expectedTitleList;

    static {
        expectedTitleList = new HashMap<>();
        expectedTitleList.put("Home page", "Book Depository: Free delivery worldwide on over 20 million books");
        expectedTitleList.put("Login page", "Facebook – log in or sign up");
        expectedTitleList.put("Search page", "Results | Book Depository");
    }

    public static String getExpectedUrlTitle(String string) {
        return expectedTitleList.get(string);
    }
}
