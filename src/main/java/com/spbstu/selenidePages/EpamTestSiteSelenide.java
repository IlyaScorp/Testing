package com.spbstu.selenidePages;

import com.spbstu.SeleniumPages.pages.ContactFormPage;
import com.spbstu.selenidePages.pages.HomePageSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EpamTestSiteSelenide {
//    public static ContactFormPage contactFormPage;
    public static HomePageSelenide homePage;

    public static void init() {
        homePage = new HomePageSelenide();
//        contactFormPage = new ContactFormPage();
    }


}