package com.spbstu.SeleniumPages.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

// TODO code convention...imports... OH MY ... GOD, yes? It will definitely help me:)
// TODO i've read code convention and haven't noticed any problems in my import expressions. What is wrong?

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
   /*TODO I had to return only icon.
    TODO чтобы вернуть List  я должен пройтись в цикле от 0 до 3 и добавить каждый WebElement в List
    TODO а потом снова проходить цикл уже в test, где каждый элемент проверять на isDisplayed()
    TODO Или лучше прйтись в цикле здесь, чтоб сформировать List. И потом в test чтоб проверить каждый элемент?
   */
    public WebElement getIcon() {

        icon = driver.findElement(By.cssSelector(String.format(".icon-%s",
                icons[iconNumber == 4 ? iconNumber = 0 : iconNumber])));
        iconNumber++;
        return icon;

    }


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
