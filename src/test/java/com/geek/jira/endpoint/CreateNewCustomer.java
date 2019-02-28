package com.geek.jira.endpoint;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.geek.jira.TestResults.class)
public class CreateNewCustomer {


    @Test()
    public void shouldBeAbleToCreateNewCustomer() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldNotBeAbleToCreateCustomerUsingUsernameThatAlreadyExists() {
        Assert.assertTrue(false);
    }

    @Test
    public void shouldBeAbleToCreateCustomerWithoutEmailAddress() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldReturn201CreatedReponse() {
        Assert.assertTrue(true);
    }

    @Test
    public void shouldFailWhenCreatingCustomerWithoutAddress() {
        Assert.assertTrue(false);
    }

    @Test
    public void shouldBeAbleToCreateCustomerWithoutPaymentDetails() {
        Assert.assertTrue(true);
    }
}
