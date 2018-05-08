package com.spbstu.hw4;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.selenidePages.EpamTestSiteSelenide;
import com.spbstu.selenidePages.enums.USER_DATA;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTest {

    final String[] TEXT = {"To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM projec",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…" };
    final String MAINTITLE = "EPAM FRAMEWORK WISHES…";
    final String SECONDTITLE = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    @BeforeClass
    public void beforeClass(){
        Configuration.browser = "chrome";
        EpamTestSiteSelenide.init();
    }


    @Test
    public void Test() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(),USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.homePage.pictureExist();
        EpamTestSiteSelenide.homePage.textUnderPictureExist();
        EpamTestSiteSelenide.homePage.mainTitleExist();
        EpamTestSiteSelenide.homePage.seconsTitleExist();
    }


}
