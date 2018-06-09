package com.spbstu.selenidePages.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;


public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    SelenideElement profilePhoto;


    @FindBy(css = "#Login")
    SelenideElement loginField;

    @FindBy(css = "#Password")
    SelenideElement passwordField;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    @FindBy(css = ".icon-")
    List<SelenideElement> pictures;

    @FindBy(css = "div.col-sm-3")
    List<SelenideElement> textUnderPictures;

    @FindBy(css = "h3")
    SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    SelenideElement secondTitle;

    @FindBy(css = ".dropdown-menu")
    SelenideElement serviceHeaderMenu;

    @FindBy(css = ".dropdown")
    SelenideElement serviceHeaderButton;

    @FindBy(css = ".sub-menu")
    SelenideElement serviceLeftButton;

    @FindBy(css = ".sub")
    SelenideElement serviceLeftMenu;

    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
    SelenideElement openDifferentElementsPage;

    public HomePageSelenide() {
        Selenide.page(this);
    }

    @Step("Open site")
    public void open() {
        Selenide.open("https://jdi-framework.github.io/tests/index.htm");
    }

    @Step("Try to sign up")
    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    @Step("Verify user has logged, hasn't he:)")
    public void checkUserLogIn(String userName) {
        profilePhoto.shouldHave(exactText(userName));
    }

    @Step("Are there pictures on main page")
    public void isPictureExist() {
        pictures.stream().skip(2).forEachOrdered(a -> a.should(exist));
    }

    @Step("Are there pictures under text on main page")
    public void isTextUnderPictureExist() { textUnderPictures.forEach(a -> a.should(exist)); }

    @Step("Is there main title")
    public void isMainTitleExist() {
        mainTitle.should(exist);
    }

    @Step("Is there second title")
    public void isSecondTitleExist() {
        secondTitle.should(exist);
    }

    @Step("Verify workability of the header menu")
    public void clickAndCheckHeaderService(String[] menu) {
        if (serviceHeaderMenu.is(hidden)) {
            serviceHeaderButton.click();
        }
        serviceHeaderMenu.shouldBe(visible);
        Arrays.stream(menu).forEach(e -> serviceHeaderMenu.shouldHave(text(e)));
        /*
        Не очень нравится такой вариант. Получается,
        помимо значений из списка параметра метода menu в
        выпадающем окошке HeaderMenu могут быть другие значения.
        А в этом тесте нельзя учесть ни порядок элементов, ни возможно лишних элементов.
        Прокомментируйте, пожалуйста.
        */
    }

    @Step("Verify left menu workability")
    public void clickAndCheckMenuService(String[] menu) {
        if (serviceLeftMenu.is(hidden)) {
            serviceLeftButton.click();
        }
        serviceLeftMenu.shouldBe(visible);
        Arrays.stream(menu).forEach(e -> serviceLeftMenu.shouldHave(text(e)));
    }

    @Step("Open Different elements page")
    public void openDifferentElementsPage() {
        serviceHeaderButton.click();
        openDifferentElementsPage.click();
    }


}