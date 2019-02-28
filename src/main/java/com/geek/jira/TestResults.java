package com.geek.jira;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;

public class TestResults extends TestListenerAdapter {

    @Override
    public void onFinish(ITestContext testContext) {
        String jira = Comment.generate(testContext);
        System.out.println(jira);
    }

}
