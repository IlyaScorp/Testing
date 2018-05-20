package com.spbstu.selenidePages.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static com.codeborne.selenide.Condition.*;

public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    List<SelenideElement> labelCheckboxes;

    @FindBy(css = ".label-radio")
    List<SelenideElement> labelRadios;

    @FindBy(css = ".uui-form-element option")
    List<SelenideElement> colorsDropdown;

    @FindBy(css = ".colors .uui-button")
    List<SelenideElement> colorButtons;

    @FindBy(css = ".uui-info")
    List<SelenideElement> sections;

    @FindBy(css = ".logs li")
    List<SelenideElement> webLogs;


    @FindBy(css = ".dropdown")
    SelenideElement serviceHeaderButton;

    @FindBy(css = ".dropdown-menu | [href=\"page4.htm\"]")
    SelenideElement datesPage;

    Map<String, Boolean> currentRadios = new HashMap<>();
    List<String> logs = new LinkedList<>();


    public DifferentElementsPage() {
        Selenide.page(this);
        currentRadios.put("Water", false);
        currentRadios.put("Wind", false);
        currentRadios.put("Fire", false);
        currentRadios.put("Earth", false);
    }

    public void isCheckboxesExist(List<String> nameBoxes) {
        Iterator<String> boxIterator = nameBoxes.iterator();
        labelCheckboxes.forEach(e -> {
            e.should(exist);
            e.shouldHave(text(boxIterator.next()));
        });
    }

    public void isRadiosExist(List<String> nameRadios) {
        Iterator<String> radiosIterator = nameRadios.iterator();
        labelRadios.forEach(e -> {
            e.should(exist);
            e.shouldHave(text(radiosIterator.next()));
        });
    }

    public void isDropdownExist(List<String> colorsList) {
        Iterator<String> colorsIterator = colorsList.iterator();
        colorsDropdown.forEach(e -> e.shouldHave(text(colorsIterator.next())));
    }

    public void isButtonsAndSectionsExist() {
        colorButtons.forEach(e -> {
            e.should(exist);
            e.should(visible);
        });
        sections.forEach(e -> {
            e.should(exist);
            e.should(visible);
        });

    }


    public void setColor(String color) {
        colorsDropdown.stream().filter(e -> e.is(text(color)))
                .forEach(SelenideElement::click);
        logs.add(String.format("Colors: value changed to %s", color));
    }

    public void setMetal(String metal) {
        labelRadios.stream().filter(e -> e.is(text(metal)))
                .forEach(SelenideElement::click);
        logs.add(String.format("metal: value changed to %s", metal));
    }

    public void switchConditions(String cond) {
        labelCheckboxes.stream().filter(e -> e.is(text(cond)))
                .forEach(SelenideElement::click);


        if (currentRadios.get(cond)) {
            currentRadios.put(cond, false);
            logs.add(String.format("%s: condition changed to %s", cond, "false"));
        } else {
            currentRadios.put(cond, true);
            logs.add(String.format("%s: condition changed to %s", cond, "true"));
        }
    }

    public void checkLogs() {
        int length = webLogs.size();
        for (int i = 0; i < length; i++) {
            webLogs.get(i).shouldHave(text(logs.get(length - i - 1)));
        }
    }

    public void openDatesPage() {
        serviceHeaderButton.click();
        datesPage.click();
    }
}
