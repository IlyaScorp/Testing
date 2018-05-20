package com.spbstu.selenidePages;

import com.spbstu.SeleniumPages.pages.ContactFormPage;
import com.spbstu.selenidePages.pages.Dates;
import com.spbstu.selenidePages.pages.DifferentElementsPage;
import com.spbstu.selenidePages.pages.HomePageSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EpamTestSiteSelenide {
//    public static ContactFormPage contactFormPage;
    public static HomePageSelenide homePage;
    public static DifferentElementsPage elementsPage;
    public static Dates dates;

    public static void init() {
        homePage = new HomePageSelenide();
        elementsPage = new DifferentElementsPage();
        dates = new Dates();
    }


}