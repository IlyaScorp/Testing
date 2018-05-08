package com.spbstu.hw3;

import com.spbstu.SeleniumPages.EpamTestSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Ex2-3. PageObject.
 */
<<<<<<< HEAD
// TODO this code does not match with code conventions !
//    TODO я не въезжаю. У вас ведь все так-же.

=======

// TODO this code does not match with code conventions !
>>>>>>> 40ae8d8ea0b1c5fa70e11644f6c78cf07e44432c
public class LoginTests {


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
    final String MAINTITLE = "EPAM FRAMEWORK WISHES…";
    final String SECONDTITLE = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        EpamTestSite.init(driver);

    }

    @Test
    public void loginTest() {
        EpamTestSite.homePage.open();
        Assert.assertEquals(EpamTestSite.homePage.getTitle(),"Index Page");
        EpamTestSite.homePage.login("epam", "1234");
        Assert.assertEquals(EpamTestSite.homePage.getName(),"PITER CHAILOVSKII");
        Assert.assertEquals(EpamTestSite.homePage.getTitle(),"Index Page");

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(EpamTestSite.homePage.getIcon().isDisplayed());
        }

        WebElement tmp;
        for (int i = 0; i < 4; i++) {
            tmp = EpamTestSite.homePage.getIconElement();
            Assert.assertTrue(tmp.isDisplayed());
            Assert.assertEquals(tmp.getText(),TEXT[i]);
        }

        tmp = EpamTestSite.homePage.getMainTitle();
        Assert.assertTrue(tmp.isDisplayed());
        Assert.assertEquals(tmp.getText(),MAINTITLE);

        tmp = EpamTestSite.homePage.getSecondTitle();
        Assert.assertTrue(tmp.isDisplayed());
        Assert.assertEquals(tmp.getText(),SECONDTITLE);

        EpamTestSite.homePage.closeDriver();

    }
}
