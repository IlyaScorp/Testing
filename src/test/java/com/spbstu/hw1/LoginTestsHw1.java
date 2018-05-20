package com.spbstu.hw1;

import com.spbstu.utils.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTestsHw1 {


    String[] TEXT;
    private WebDriver driver;
    private WebElement element;
    private TestConfig cfg;

    @BeforeSuite
    public void beforeSuite() {
        cfg = ConfigFactory.create(TestConfig.class);
        TEXT = cfg.titles();
        TEXT[3] = TEXT[3].concat(",\n").concat(TEXT[4]);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @Test
    public void LoginTestsHw1() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
        driver.findElement(By.cssSelector(".profile-photo")).click(); //клик по фото пользователя
        driver.findElement(By.cssSelector("#Login")).sendKeys("epam"); //ввести логин
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234"); //ввести пароль
        driver.findElement(By.cssSelector("form .btn-login")).click();

        element = driver.findElement(By.cssSelector(".profile-photo"));
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), "PITER CHAILOVSKII");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        WebElement icon;
        for (int i = 0; i < 4; i++) {                                    // проверка иконок
            icon = driver.findElement(By.cssSelector(String.format(".icon-%s",
                    cfg.icons()[i])));
            Assert.assertTrue(icon.isDisplayed());
        }

        List<WebElement> textIcon;
        textIcon = driver.findElements(By.cssSelector("div.col-sm-3")); // проверка текста под иконками
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(textIcon.get(i).isDisplayed());
            Assert.assertEquals(TEXT[i], textIcon.get(i).getText());
        }

        element = driver.findElement(By.cssSelector("h3"));             // проверка заголовка
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), cfg.mainTitle());

        element = driver.findElement(By.cssSelector(".main-txt"));      // проверка подзаголовка
        Assert.assertTrue(element.isDisplayed());
        Assert.assertEquals(element.getText(), cfg.secondTitle());

        driver.close();
    }


}
