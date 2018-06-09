package com.spbstu.JDIPages.pages;

import com.codeborne.selenide.Condition;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextArea;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.settings.WebSettings;
import com.spbstu.JDIPages.entities.Data;
import com.spbstu.JDIPages.sections.Ovoshi;
import com.spbstu.JDIPages.sections.Summary;
import com.spbstu.JDIPages.sections.enums.ELEMENTS;
import com.spbstu.enums.elements_page.COLORS;
import com.spbstu.enums.elements_page.METAL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;


@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalAndColors extends WebPage {

    @FindBy(id = "summary-block")
    public Summary summary;

    @FindBy(id = "elements-block")
    public Ovoshi elements;


    @JFindBy(css = "#elements-checklist p label")
    public ICheckList<ELEMENTS> elementsList = new CheckList<ELEMENTS>() {
        @Override
        public void uncheckAll() {
            List<WebElement> boxes = WebSettings.getDriver().findElements(By.cssSelector("#elements-checklist > p > input"));
            int len = boxes.size();
            for (int i = 0; i < len; i++) {
                if ("true".equals(boxes.get(i).getAttribute("checked"))) {
                    this.check(i + 1);
                }
            }
        }
    };

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li")
    )
    public Dropdown<COLORS> colorsDropDown;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jexpand = @JFindBy(css = ".caret"),
            jlist = @JFindBy(tagName = "li")
    )
    public Dropdown<METAL> metalDropDown;

    @JFindBy(css = ".salad li")
    public Ovoshi ovoshiList;

    @JFindBy(css = ".results")
    public TextArea results;

    @JFindBy(id = "submit-button")
    public Button getRsultsButton;

    public void checkResults(Data data) {
        results.shouldHave(Condition.text(Integer.toString(data.getSummary()[0] + data.getSummary()[1]).toString()));
        results.shouldHave(Condition.text(data.getColor()));
        results.shouldHave(Condition.text(data.getMetals()));
        Arrays.stream(data.getElements()).forEach(a -> results.shouldHave(Condition.text(a)));
        Arrays.stream(data.getVegetables()).forEach(a -> results.shouldHave(Condition.text(a)));
    }
}
