package com.spbstu.hw4;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.SeleniumPages.EpamTestSite;
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

        EpamTestSiteSelenide.init();
    }


    @Test(enabled = false)
    public void caseOne() {
        // TODO URL should be set in pom.xml or .properties file

        // TODO ATTENTION!!! How can i set URL in pom file?
        // TODO I thought I could do it as i set webrdiver,
        // TODO but webdriver relate to <systemPropertyVariables>, URL doesn't.
        // TODO I can only specify URL in <profile> and add test.url=${test.url} to data.properties
        // TODO yes, you're right. You've done exactly what i told !)

        Selenide.open(config().name());
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.homePage.isPictureExist();
        EpamTestSiteSelenide.homePage.isTextUnderPictureExist();
        EpamTestSiteSelenide.homePage.isMainTitleExist();
        EpamTestSiteSelenide.homePage.isSecondTitleExist();
        EpamTestSiteSelenide.homePage.clickAndCheckHeaderService(HOME_PAGE.SERVICE.getArrValue());
        EpamTestSiteSelenide.homePage.clickAndCheckMenuService(HOME_PAGE.SERVICE.getArrValue());
        EpamTestSiteSelenide.homePage.openDifferentElementsPage();
        /*
         * Attention! Попробуйте НЕ закооментировать метод openDifferentElementsPage и
         * провестести следующие два тест: elementsPage.isCheckboxesExist
         *                                 elementsPage.isRadiosExist
         * У меня почему то они не падают на homePage. Хотя там радиокнопок и чекбоксов нет.
         * Что не так?
         * Начиная с isDropdownExist уже падает(не находит).
         * */
        // TODO of course!! It is completely essential to check the collection SIZE before .forEach cycle.
        // TODO otherwise, in case if you have no elements, .forEach will not execute at all...
        EpamTestSiteSelenide.elementsPage.isCheckboxesExist(CONDITIONS.values());
        EpamTestSiteSelenide.elementsPage.isRadiosExist(RADIOS.values());
        EpamTestSiteSelenide.elementsPage.isDropdownExist(COLORS.values());
        EpamTestSiteSelenide.elementsPage.isButtonsAndSectionsExist();
        // TODO it will be better if you create emup for this purpose
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
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.elementsPage.openDatesPage();
        // TODO Test doesn't work. Peek inside method and pay attention on comments
        EpamTestSiteSelenide.dates.shiftSlider(0, 100);
//        EpamTestSiteSelenide.dates.checkLogs();
//        EpamTestSiteSelenide.dates.shiftSlider(0,0);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
