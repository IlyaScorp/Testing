package com.spbstu.selenidePages.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Dates {

    @FindBy(css = ".ui-slider-handle span")
    List<SelenideElement> sliders;


    public Dates() {
        Selenide.page(this);
    }

    public void shiftSlider() {
//        new Actions(WebDriverRunner.getWebDriver()).dragAndDropBy(sliders.get(0),32,0).perform();
//        sliders.get(0).dragAndDropTo("left:20%");
        System.out.println("-----");
        System.out.println(sliders.get(0).innerText());
        System.out.println(sliders.get(1).innerText());
        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
//        WebElement element = (WebElement) sliders;
        js.executeScript("arguments[0].setAttribute('style', 'left: 11%')",sliders.get(0));
        new Actions(WebDriverRunner.getWebDriver()).dragAndDropBy(sliders.get(0),17,0);
        new Actions(WebDriverRunner.getWebDriver()).dragAndDropBy(sliders.get(1),23,0);
        System.out.println(sliders.get(0).innerText());
        System.out.println(sliders.get(1).innerText());
        System.out.println("-----");
//        sliders.get(0).dragAndDropTo("[style=\"left: 27%");
    }
}
