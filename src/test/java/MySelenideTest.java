/* Copyright (C) 2018 Svetlana Nekhoroshikh
   Telematics
   33607
 */

import allure.AllureAttachmentListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import enums.HomeList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import static com.codeborne.selenide.Selenide.zoom;

import static com.codeborne.selenide.Configuration.SelectorMode.Sizzle;
import static enums.DifferentDate.*;
import static enums.HomeDate.*;


//http://ru.selenide.org/documentation.html

//Create a new test in a new Java class, specify test name accordingly checking functionality
@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test (Page Object)"})
@Stories({"MySelenide Test"})
public class MySelenideTest {
    private static WebDriver driver;

    @BeforeSuite
    public static void BeforeTestSelenide() {
        //1 Create a new test
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Светлана\\IdeaProjects\\EpamHomeWork3\\drivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();//размер окна
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        //Configuration.timeout = 50000;
//        Configuration.browserSize="7x700";
        Configuration.selectorMode = Sizzle; //Теперь в Selenide можно использовать CSS3 селекторы для поиска элементов!
        EpamSelenid.init();
    }

    @Test
    public void Case1() {
        //HomePage
        zoom(0.80);
        EpamSelenid.homePage.open();
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        EpamSelenid.homePage.check4Text();
        EpamSelenid.homePage.check2Text(HOME_PAGE_TEXT.toString(), HOME_PAGE_TITLE.toString());
        EpamSelenid.homePage.picture();
        EpamSelenid.homePage.existDropHeader(HomeList.MENU_TEXTS.strList);
        EpamSelenid.homePage.existDropLeft(HomeList.MENU_TEXTS.strList);
        EpamSelenid.homePage.openPageElement();
        //Different Element Page
        EpamSelenid.diffPage.interfaceServing();
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.selectRadios();
        EpamSelenid.diffPage.selectDropdown(DROPDOWN.toString());
        EpamSelenid.diffPage.checkLogsSelected(CHECKBOX1.toString(), CHECKBOX2.toString(), RADIOB.toString(), DROPDOWN.toString());
        EpamSelenid.diffPage.selectUn(DROPDOWN.toString());
        Selenide.refresh();//обновление страниц
        EpamSelenid.diffPage.selectCheckBox();
        EpamSelenid.diffPage.checkLogSelected(CHECKBOX1.toString(), CHECKBOX2.toString());
    }
/*
    @Test(enabled = false)
    public void Case2() {
        //HomePage
        //Open test site by URL
        EpamSelenid.homePage.open();
        //Perform login
        EpamSelenid.homePage.login(LOGIN.toString(), PASSWORD.toString());
        //Assert User name in the left-top side of screen that user is loggined
        EpamSelenid.homePage.checkUserLogIn(USER_NAME.toString());
        //Open Service -> Dates
        EpamSelenid.homePage.openPageDates();
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        EpamSelenid.dataPage.setDragAndDrop(0, 100);
        //Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        EpamSelenid.dataPage.setDragAndDrop(0, 0);
        //Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        EpamSelenid.dataPage.setDragAndDrop(100, 100);
        //Using drag-and-drop set Range sliders.
        EpamSelenid.dataPage.setDragAndDrop(30, 70);
    }
    */
}

