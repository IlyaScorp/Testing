package com.spbstu.selenidePages.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.spbstu.selenidePages.users.User;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class HomePageSelenide {
    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;

    @FindBy(css = "#Login")
    SelenideElement loginField;

    @FindBy(css = "#Password")
    SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    public HomePageSelenide() {
        Selenide.page(this);
    } // так, и зачем это здесь?


    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    public void checkUserLogIn(String userName) {
        profilePhoto.shouldHave(exactText(userName));
     }

    public void pictureExist(){
        $$(".icon-").stream().skip(2).forEachOrdered(a -> a.should(exist));
    }

    public void textUnderPictureExist(){
        $$("div.col-sm-3").stream().forEachOrdered(a -> a.should(exist));
    }

    public void mainTitleExist(){
        $("h3").should(exist);
    }

    public void seconsTitleExist(){
        $(".main-txt").should(exist);
    }

}
