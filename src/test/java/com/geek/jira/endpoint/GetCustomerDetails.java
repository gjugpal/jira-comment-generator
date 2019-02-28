package com.geek.jira.endpoint;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.geek.jira.TestResults.class)
public class GetCustomerDetails {


    @Test()
    public void shouldReturnTheCorrectProfile() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnValidAge() {
        Assert.assertTrue(false);
    }

    @Test
    public void shouldNotReturnUsername() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldDisplayAddress() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturnCorrectLastname() {
        Assert.assertTrue(false);
    }

    @Test
    public void shouldNotDisplayBankDetails() {
        Assert.assertTrue(true);
    }
}
