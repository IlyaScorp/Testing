package com.spbstu.JDIPages.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.spbstu.JDIPages.entities.User;
import com.spbstu.JDIPages.sections.LoginForm;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;


@JPage(url = "/index.htm", title = "Index Page")
public class HomePage extends WebPage {

    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;

    @JFindBy(css = ".m-l8")
    public Menu headerMenu;

    @Step
    public void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }
}
