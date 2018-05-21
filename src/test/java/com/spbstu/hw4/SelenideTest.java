package com.spbstu.hw4;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.enums.ELEMENTS_PAGE;
import com.spbstu.enums.HOME_PAGE;
import com.spbstu.enums.USER_DATA;
import com.spbstu.selenidePages.EpamTestSiteSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

// TODO poor code convention... i fix it specially for you !
public class SelenideTest {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
//        Configuration.headless = true;
        EpamTestSiteSelenide.init();
    }


    @Test(enabled = true)
    public void caseOne() {
        // TODO URL should be set in pom.xml or .properties file
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.homePage.isPictureExist();
        EpamTestSiteSelenide.homePage.isTextUnderPictureExist();
        EpamTestSiteSelenide.homePage.isMainTitleExist();
        EpamTestSiteSelenide.homePage.isSecondTitleExist();
        EpamTestSiteSelenide.homePage.clickAndCheckHeaderService(HOME_PAGE.SERVICE.getArrValue());
        EpamTestSiteSelenide.homePage.clickAndCheckMenuService(HOME_PAGE.SERVICE.getArrValue());
//        EpamTestSiteSelenide.homePage.openDifferentElementsPage();
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
        EpamTestSiteSelenide.elementsPage.isCheckboxesExist((List<String>) ELEMENTS_PAGE.CHECK_BOXES.getValue());
        EpamTestSiteSelenide.elementsPage.isRadiosExist((List<String>) ELEMENTS_PAGE.RADIOS.getValue());
        EpamTestSiteSelenide.elementsPage.isDropdownExist((List<String>) ELEMENTS_PAGE.COLORS_DROPDOWN.getValue());
        EpamTestSiteSelenide.elementsPage.isButtonsAndSectionsExist();
        // TODO it will be better if you create emup for this purpose
        EpamTestSiteSelenide.elementsPage.switchConditions("Water");
        EpamTestSiteSelenide.elementsPage.switchConditions("Wind");
        EpamTestSiteSelenide.elementsPage.setMetal("Selen");
        EpamTestSiteSelenide.elementsPage.setColor("Yellow");
        EpamTestSiteSelenide.elementsPage.switchConditions("Water");
        EpamTestSiteSelenide.elementsPage.switchConditions("Wind");
        EpamTestSiteSelenide.elementsPage.checkLogs();
    }

    @Test(enabled = false)
    public void caseTwo() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.elementsPage.openDatesPage();
        EpamTestSiteSelenide.dates.shiftSlider();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
