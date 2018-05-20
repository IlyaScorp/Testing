package com.spbstu.hw4;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.SeleniumPages.EpamTestSite;
import com.spbstu.enums.HOME_PAGE;
import com.spbstu.enums.USER_DATA;
import com.spbstu.selenidePages.EpamTestSiteSelenide;
import com.spbstu.utils.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelenideTest {

    String[] TEXT;
    private TestConfig cfg;


    @BeforeClass
    public void beforeClass() {

        cfg = ConfigFactory.create(TestConfig.class);
        TEXT = cfg.titles();
        TEXT[3] = TEXT[3].concat(",\n").concat(TEXT[4]);
        Configuration.browser = "chrome";
        Configuration.startMaximized=true;
        Configuration.headless = true;
        EpamTestSiteSelenide.init();
    }


    @Test(enabled = false)
    public void caseOne() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
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
        EpamTestSiteSelenide.elementsPage.isCheckboxesExist(HOME_PAGE.CHECK_BOXES.getListValue());
        EpamTestSiteSelenide.elementsPage.isRadiosExist(HOME_PAGE.RADIOS.getListValue());
        EpamTestSiteSelenide.elementsPage.isDropdownExist(HOME_PAGE.COLORS_DROPDOWN.getListValue());
        EpamTestSiteSelenide.elementsPage.isButtonsAndSectionsExist();
        EpamTestSiteSelenide.elementsPage.switchConditions("Water");
        EpamTestSiteSelenide.elementsPage.switchConditions("Wind");
        EpamTestSiteSelenide.elementsPage.setMetal("Selen");
        EpamTestSiteSelenide.elementsPage.setColor("Yellow");
        EpamTestSiteSelenide.elementsPage.switchConditions("Water");
        EpamTestSiteSelenide.elementsPage.switchConditions("Wind");
        EpamTestSiteSelenide.elementsPage.checkLogs();

    }

    @Test
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
