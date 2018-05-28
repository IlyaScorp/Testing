package com.spbstu.hw4;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.enums.HOME_PAGE;
import com.spbstu.enums.USER_DATA;
import com.spbstu.enums.elements_page.COLORS;
import com.spbstu.enums.elements_page.CONDITIONS;
import com.spbstu.enums.elements_page.RADIOS;
import com.spbstu.selenidePages.EpamTestSiteSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.spbstu.utils.ConfigLoader.config;

public class SelenideTest {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
//        Configuration.headless = true;
//        Configuration.browserSize = "1200x700";

        EpamTestSiteSelenide.init();
    }


    @Test(enabled = false)
    public void caseOne() {

        Selenide.open(config().url());

        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.homePage.isPictureExist();
        EpamTestSiteSelenide.homePage.isTextUnderPictureExist();
        EpamTestSiteSelenide.homePage.isMainTitleExist();
        EpamTestSiteSelenide.homePage.isSecondTitleExist();
        EpamTestSiteSelenide.homePage.clickAndCheckHeaderService(HOME_PAGE.SERVICE.getArrValue());
        EpamTestSiteSelenide.homePage.clickAndCheckMenuService(HOME_PAGE.SERVICE.getArrValue());
        EpamTestSiteSelenide.homePage.openDifferentElementsPage();
        EpamTestSiteSelenide.elementsPage.isCheckboxesExist(CONDITIONS.values());
        EpamTestSiteSelenide.elementsPage.isRadiosExist(RADIOS.values());
        EpamTestSiteSelenide.elementsPage.isDropdownExist(COLORS.values());
        EpamTestSiteSelenide.elementsPage.isButtonsAndSectionsExist();
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.WATER.getValue());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.WIND.getValue());
        EpamTestSiteSelenide.elementsPage.setMetal(RADIOS.SELEN.getValue());
        EpamTestSiteSelenide.elementsPage.setColor(COLORS.YELLOW.getValue());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.WATER.getValue());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.WIND.getValue());
        EpamTestSiteSelenide.elementsPage.checkLogs();
    }


    @Test(enabled = true)
    public void caseTwo() throws InterruptedException {

        Selenide.open(config().url());
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.elementsPage.openDatesPage();
        // TODO Test doesn't work. Peek inside method and pay attention on comments
        EpamTestSiteSelenide.dates.shiftSlider(0, 100);
        EpamTestSiteSelenide.dates.shiftSlider(0, 0);
        EpamTestSiteSelenide.dates.shiftSlider(100, 100);
        EpamTestSiteSelenide.dates.shiftSlider(30, 70);

    }
}
