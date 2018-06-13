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
import com.epam.web.matcher.testng.Check;
import com.spbstu.JDIPages.entities.MetalsColorsData;
import com.spbstu.JDIPages.sections.MetalsColorsForm.Ovoshi;
import com.spbstu.JDIPages.sections.MetalsColorsForm.Summary;
import com.spbstu.JDIPages.sections.enums.ELEMENTS;
import com.spbstu.enums.elements_page.COLORS;
import com.spbstu.enums.elements_page.METAL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.Arrays;
import java.util.List;


@JPage(url = "/page2.htm", title = "Metal and Colors")
public class MetalAndColors extends WebPage {

    @FindBy(id = "summary-block")
    private Summary summary;

    @FindBy(id = "elements-block")
    public Ovoshi elements;


    @JFindBy(css = "#elements-checklist p label")
    private ICheckList<ELEMENTS> elementsList = new CheckList<ELEMENTS>() {
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
    private Dropdown<COLORS> colorsDropDown;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jexpand = @JFindBy(css = ".caret"),
            jlist = @JFindBy(tagName = "li")
    )
    private Dropdown<METAL> metalDropDown;

    @JFindBy(css = ".salad li")
    private Ovoshi ovoshiList;

    @JFindBy(css = ".results")
    private TextArea results;

    @JFindBy(id = "submit-button")
    private Button getRsultsButton;


    @Step
    public void checkResults(MetalsColorsData metalsColorsData) {
        int elementAmount = 0;
        String[] resultArr = results.getLines();
        for (String aResultArr : resultArr) {

            if (aResultArr.startsWith("Elements") || aResultArr.startsWith("Vegetables")) {
                String[] tmp = aResultArr.split("[,:]");
                if (tmp[1].length() < 3) {
                    continue;
                }
                // the if block is required to check existence of a word after :
                elementAmount += tmp.length - 1;

            }
        }
        new Check().areEquals(elementAmount, metalsColorsData.getElements().length + metalsColorsData.getVegetables().length);
        results.shouldHave(Condition.text(Integer.toString(metalsColorsData.getSummary()[0] + metalsColorsData.getSummary()[1])));
        results.shouldHave(Condition.text(metalsColorsData.getColor()));
        results.shouldHave(Condition.text(metalsColorsData.getMetals()));
        Arrays.stream(metalsColorsData.getElements()).forEach(a -> results.shouldHave(Condition.text(a)));
        Arrays.stream(metalsColorsData.getVegetables()).forEach(a -> results.shouldHave(Condition.text(a)));
    }

    @Step
    public void submitForm(MetalsColorsData metalsColorsData) {
        summary.boxFirst.select(Integer.toString(metalsColorsData.getSummary()[0]));
        summary.boxLast.select(Integer.toString(metalsColorsData.getSummary()[1]));
        elementsList.uncheckAll();
        elementsList.check(metalsColorsData.getElements());
        colorsDropDown.select(metalsColorsData.getColor());
        metalDropDown.select(metalsColorsData.getMetals());
        ovoshiList.expand();
        ovoshiList.uncheckAll();
        ovoshiList.select(metalsColorsData.getVegetables());
        getRsultsButton.click();
    }
}
