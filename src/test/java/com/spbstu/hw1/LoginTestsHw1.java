package com.spbstu.hw1;

import com.spbstu.EpamTestSite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTestsHw1 {


    private WebDriver driver;
    private WebElement element;

    final String[] icons = {"practise", "custom", "multi", "base"};
    final String[] TEXT = {"To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM projec",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…" };
    String MAINTITLE = "EPAM FRAMEWORK WISHES…";
    String SECONDTITLE = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @Test
    public void LoginTestsHw1(){
        Assert.assertEquals(driver.getTitle(),"Index Page");
        driver.findElement(By.cssSelector(".profile-photo")).click(); //клик по фото пользователя
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam"); //ввести логин
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234"); //ввести пароль
        driver.findElement(By.cssSelector("form .btn-login")).click();

        element = driver.findElement(By.cssSelector(".profile-photo"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),"PITER CHAILOVSKII");
        Assert.assertEquals(driver.getTitle(),"Index Page");

        WebElement icon;
        for (int i = 0; i < 4; i++) {                               // проверка иконок
            icon = driver.findElement(By.cssSelector(String.format(".icon-%s",
                    icons[i])));
            Assert.assertTrue(icon.isDisplayed());
        }

        List<WebElement> textIcon;
        textIcon = driver.findElements(By.cssSelector("div.col-sm-3")); // проверка текста под иконками
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(textIcon.get(i).isDisplayed());
            Assert.assertEquals(textIcon.get(i).getText(),TEXT[i]);
        }

        element = driver.findElement(By.cssSelector("h3")); // проверка заголовка
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),MAINTITLE);

        element = driver.findElement(By.cssSelector(".main-txt")); // проверка подзаголовка
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(),SECONDTITLE);

        driver.close();
    }



}
