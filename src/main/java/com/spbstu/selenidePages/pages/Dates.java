package com.spbstu.selenidePages.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Dates {

    @FindBy(css = ".ui-slider-handle span")
    List<SelenideElement> sliders;

    @FindBy(css = ".ui-slider-horizontal")
    SelenideElement sliderRange;

    @FindBy(css = ".logs li")

    private boolean isSliderActive = false;
    private float WIDTH;

    public Dates() {
        Selenide.page(this);
    }

    private int getPosition(SelenideElement element) {
        return Integer.parseInt(element.getText());
    }


    public void
    shiftSlider(int leftPosition, int rightPosition) throws InterruptedException {
        if (!isSliderActive) {
            sliders.get(0).scrollTo();
            sliders.get(1).scrollTo();
            WIDTH = sliderRange.getSize().width;
            isSliderActive = true;
        }

        if ((leftPosition > rightPosition) ||
                ((leftPosition > 100) || (leftPosition < 0)) ||
                ((rightPosition > 100) || (rightPosition < 0))) {
            throw new IllegalArgumentException();
        }

        Actions shiftSlider = new Actions(WebDriverRunner.getWebDriver());
        TimeUnit.SECONDS.sleep(1);
        if (leftPosition < getPosition(sliders.get(1))) {
            shiftSlider.dragAndDropBy(sliders.get(0),
                    (int) ((leftPosition - getPosition(sliders.get(0)) - 0.8f) / 100. * WIDTH), 0).perform();

            TimeUnit.SECONDS.sleep(1);
            shiftSlider.dragAndDropBy(sliders.get(1),
                    (int) ((rightPosition - getPosition(sliders.get(1)) - 0.8f) / 100. * WIDTH), 0).perform();

        } else {
            shiftSlider.dragAndDropBy(sliders.get(1),
                    (int) ((rightPosition - getPosition(sliders.get(1)) - 0.8f) / 100. * WIDTH), 0).perform();

            TimeUnit.SECONDS.sleep(1);
            shiftSlider.dragAndDropBy(sliders.get(0),
                    (int) ((leftPosition - getPosition(sliders.get(0)) - 0.8f) / 100. * WIDTH), 0).perform();

        }

        sliders.get(0).shouldHave(text(Integer.toString(leftPosition)));
        sliders.get(1).shouldHave(text(Integer.toString(rightPosition)));
    }


}
