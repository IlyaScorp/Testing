package com.spbstu.hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.enums.HOME_PAGE;
import com.spbstu.enums.USER_DATA;
import com.spbstu.enums.elements_page.COLORS;
import com.spbstu.enums.elements_page.CONDITIONS;
import com.spbstu.enums.elements_page.METAL;
import com.spbstu.selenidePages.EpamTestSiteSelenide;
import com.spbstu.utils.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.concurrent.TimeUnit;

import static com.spbstu.utils.ConfigLoader.config;

@Features("JDI test site")
@Listeners(AllureAttachmentListener.class)
public class SelenideTest {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
//        Configuration.headless = true;
        Configuration.browserSize = "780x700";

        EpamTestSiteSelenide.init();
    }

    @Title("Case ONE scenario")
    @Description("Scenario passes all steps according to case ONE")
    @Test(enabled = true)
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
        EpamTestSiteSelenide.elementsPage.isRadiosExist(METAL.values());
        EpamTestSiteSelenide.elementsPage.isDropdownExist(COLORS.values());
        EpamTestSiteSelenide.elementsPage.isButtonsAndSectionsExist();
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.Water.name());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.Wind.name());
        EpamTestSiteSelenide.elementsPage.setMetal(METAL.Selen.name());
        EpamTestSiteSelenide.elementsPage.setColor(COLORS.Yellow.name());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.Water.name());
        EpamTestSiteSelenide.elementsPage.switchConditions(CONDITIONS.Wind.name());
        EpamTestSiteSelenide.elementsPage.checkLogs();
        Selenide.close();
    }

    @Title("Case TWO scenario")
    @Description("Scenario passes all steps according to case TWO")
    @Test(enabled = true)
    public void caseTwo() throws InterruptedException {

        Selenide.open(config().url());
        TimeUnit.SECONDS.sleep(10);
        EpamTestSiteSelenide.homePage.login(USER_DATA.LOGIN.toString(), USER_DATA.PASSWORD.toString());
        EpamTestSiteSelenide.homePage.checkUserLogIn(USER_DATA.USER_NAME.toString());
        EpamTestSiteSelenide.elementsPage.openDatesPage();
        EpamTestSiteSelenide.dates.shiftSlider(0, 100);
        EpamTestSiteSelenide.dates.shiftSlider(0, 0);
        EpamTestSiteSelenide.dates.shiftSlider(100, 100);
        EpamTestSiteSelenide.dates.shiftSlider(30, 70);

    }
}
