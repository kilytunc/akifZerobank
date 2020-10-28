package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    //username locate
    @FindBy(id = "user_login" )
    public WebElement usernameInput ;

    //password locate
    @FindBy(id = "user_password" )
    public WebElement passwordInput ;

    //locate "keep me signed in" checkbox
    @FindBy(id = "user_remember_me" )
    public WebElement rememberMeCheckBox ;

    //locate "keep me signed in" checkbox
    @FindBy(name = "submit" )
    public WebElement singInButton ;

    @FindBy(css = "div.alert.alert-error" )
    public WebElement negativeLoginMessage;


    public void login(){

       usernameInput.sendKeys(ConfigurationReader.get("username"));
       passwordInput.sendKeys(ConfigurationReader.get("password"));
       singInButton.click();

    }

    public void loginWithCredentials(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        singInButton.click();

    }
}



