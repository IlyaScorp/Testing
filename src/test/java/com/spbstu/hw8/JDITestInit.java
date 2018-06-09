package com.spbstu.hw8;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.JDIPages.JDISite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class JDITestInit extends TestNGBase {


    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
    }

    @AfterSuite
    public static void closeSite() {
        WebSettings.getDriver().close();
    }
}
