package com.spbstu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


// TODO code convention...imports... OH MY
public class HomePage {
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;

    @FindBy(css = "#Login")
    WebElement loginField;

    @FindBy(css = "#Password")
    WebElement passwordField;

    @FindBy(css = ".profile-photo")
    WebElement name;

    @FindBy(css = "form .btn-login")
    WebElement submit;

    //    @FindBy(css = ".icon-practise")
    WebElement icon;
    static String[] icons = {"practise", "custom", "multi", "base"};
    private static int iconNumber = 0;

    @FindBy(css = "div.col-sm-3")
    private List<WebElement> textIcon;
    private int textNumber = 0;

    @FindBy(css = "h3")
    private
    WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private
    WebElement secondTitle;


    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getName() {
        return name.getText();
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    // TODO this is a bit strange logic, ywy dont you return List with WebElements ?
    public boolean getIcon() {

        icon = driver.findElement(By.cssSelector(String.format(".icon-%s",
                icons[iconNumber == 4 ? iconNumber = 0 : iconNumber])));
        iconNumber++;
        return icon.isDisplayed();
    }

//    public String getIconText() {
//
//        return getIconElement().getText();
//    }
//
//    public boolean textIconIsDesplayed() {
//
//        return getIconElement().isDisplayed();
//    }

    public WebElement getIconElement() {
        if (textNumber == 4) {
            textNumber = 0;
        }
        return textIcon.get(textNumber++);
    }

    public WebElement getMainTitle() {

        return mainTitle;
    }

    public WebElement getSecondTitle() {

        return secondTitle;
    }

    public void closeDriver() {

        driver.close();
    }


}
