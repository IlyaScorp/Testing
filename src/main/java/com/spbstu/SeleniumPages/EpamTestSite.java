package com.spbstu.SeleniumPages;

import com.spbstu.SeleniumPages.pages.ContactFormPage;
import com.spbstu.SeleniumPages.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class EpamTestSite {
    public static ContactFormPage contactFormPage;
    public static HomePage homePage;

    public static void init(WebDriver driver) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        contactFormPage = PageFactory.initElements(driver, ContactFormPage.class);
    }


}
