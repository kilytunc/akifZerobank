package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));


    }

    @When("the user enters to {string} {string}")
    public void the_user_enters_to(String user, String pass) {
        new LoginPage().loginWithCredentials(user,pass);

    }

    @Then("the user should see {string}")
    public void the_user_should_see(String string) {
        Assert.assertTrue("negative login message displayed?",new LoginPage().negativeLoginMessage.isDisplayed());
        Assert.assertEquals("verify the message text","Login and/or password are wrong.",new LoginPage().negativeLoginMessage.getText());
        //System.out.println(new LoginPage().negativeLoginMessage.getText());
    }


    @When("the user enter with valid credentials")
    public void the_user_enter_with_valid_credentials() {
      //there is only one valid credtnial to login -- using them with Loginpage.login
        new LoginPage().login();
    }

    @Then("user should successfully logged in")
    public void user_should_successfully_logged_in() {
        // when user enter succsfly then verify the enterence by checking title
        // i have no pageObject for account summary yet so im gonna check it by usng Driver
        String title = Driver.get().getTitle();
        Assert.assertTrue("verify the title contains Ac sum",title.contains("Account Summary"));
        System.out.println("title = " + title);


    }
}
