package com.spbstu.hw3;

import com.spbstu.SeleniumPages.EpamTestSite;
import com.spbstu.enums.HOME_PAGE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Ex2-3. PageObject. by Ilya Belan
 */
// TODO this code does not match with code conventions !
//    TODO я не въезжаю. У вас ведь все так-же.

public class LoginTests {

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
        Assert.assertEquals(EpamTestSite.homePage.getTitle(), "Index Page");
        EpamTestSite.homePage.login("epam", "1234");
        Assert.assertEquals(EpamTestSite.homePage.getName(), "PITER CHAILOVSKII");
        Assert.assertEquals(EpamTestSite.homePage.getTitle(), "Index Page");

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(EpamTestSite.homePage.getIcon().isDisplayed());
        }
        WebElement tmp;
        for (int i = 0; i < 4; i++) {
            tmp = EpamTestSite.homePage.getIconElement();
            Assert.assertTrue(tmp.isDisplayed());
            Assert.assertEquals(tmp.getText(), HOME_PAGE.TEXT.getArrValue()[i]);
        }

        tmp = EpamTestSite.homePage.getMainTitle();
        Assert.assertTrue(tmp.isDisplayed());
        Assert.assertEquals(tmp.getText(), HOME_PAGE.MAIN_TITLE.getValue());

        tmp = EpamTestSite.homePage.getSecondTitle();
        Assert.assertTrue(tmp.isDisplayed());
        Assert.assertEquals(tmp.getText(), HOME_PAGE.SECOND_TITLE.getValue());

        EpamTestSite.homePage.closeDriver();

    }
}
