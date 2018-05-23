package com.spbstu.selenidePages.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static java.lang.Math.abs;

import java.util.LinkedList;
import java.util.List;


public class Dates {

    //slider.get(0) - leftSlider
    //slider.get(1) - rightSlider
    @FindBy(css = ".ui-slider-handle span")
    List<SelenideElement> sliders;

    @FindBy(css = ".ui-slider-range")
    SelenideElement sliderRange;

    @FindBy(css = ".logs li")
    List<SelenideElement> webLogs;

    private float SLIDER_STEP;
    private boolean isSliderActive = false;
    private List<String> logs = new LinkedList<>();

    public Dates() {
        Selenide.page(this);
    }

    private int getPosition(SelenideElement element) {
        return Integer.parseInt(element.getText());
    }

    public void shiftSlider(int leftPosition, int rightPosition) throws InterruptedException {
        if (!isSliderActive) {
            // TODO В интернете написано, что необходимо включить нативные события для использования Actions
            // TODO В configurations ничего такого не нашлось. Только после scrollTo задвигались слайдеры
            sliders.get(0).scrollTo();
            sliders.get(1).scrollTo();
            SLIDER_STEP = (sliderRange.getSize().width /
                    ((float) abs(getPosition(sliders.get(1)) - getPosition(sliders.get(0))) + 0.5f));
            isSliderActive = true;
        }

        if ((leftPosition > rightPosition) ||
                ((leftPosition > 100) || (leftPosition < 0)) ||
                ((rightPosition > 100) || (rightPosition < 0))) {
            throw new IllegalArgumentException();
        }

        // TODO Просто разделить width линии на положение ползунков (100 - 20) не дает правильный размер шага.
        Actions shiftSlider = new Actions(WebDriverRunner.getWebDriver());
        System.out.println("------");
        System.out.println(sliderRange.getSize().width);
        // TODO введенная коррекция  + 0.5f немного спасате, но только немного.
        // TODO ниже, если напишем -20, то ползунок остановиться на 1. А должен бы на 0.
        shiftSlider.dragAndDropBy(sliders.get(0), (int) (-21 * SLIDER_STEP), 0).perform();
        //хорошо, тут ползунок ноль.
        Thread.sleep(1000);

        shiftSlider.dragAndDropBy(sliders.get(0), (int) (98 * SLIDER_STEP), 0).perform();
        // на этом шаге тоже ничего, получается выставить ползунок в 98
        Thread.sleep(1000);
        System.out.println(sliderRange.getSize().width); // здесь width = 5

        shiftSlider.dragAndDropBy(sliders.get(0), -200, 0).perform();
        // TODO а вот тут полная неразбериха. Ожидаю увидеть width = 205, а он 202.
        // TODO причем если сделать оффсет -100, то width  = 104, то есть разброс меньше.
        // TODO всякие костыли ставить, лишь бы тест прошел не хочется...
        Thread.sleep(1000);

        System.out.println(sliderRange.getSize().width);

        Thread.sleep(1000);
//        if (leftPosition < getPosition(sliders.get(1))) {
//            shiftSlider.dragAndDropBy(sliders.get(0),
//                    (int) ((leftPosition - getPosition(sliders.get(0))) * SLIDER_STEP), 0).perform();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            shiftSlider.dragAndDropBy(sliders.get(1),
//                    (int) ((rightPosition - getPosition(sliders.get(1))) * SLIDER_STEP), 0).perform();
//            logs.add(String.format("(From):%s link clicked",leftPosition));
//            logs.add(String.format("(To):%s link clicked",rightPosition));
//        } else {
//            shiftSlider.dragAndDropBy(sliders.get(1),
//                    (int) ((leftPosition - getPosition(sliders.get(1))) * SLIDER_STEP), 0).perform();
//            shiftSlider.dragAndDropBy(sliders.get(0),
//                    (int) ((rightPosition - getPosition(sliders.get(0))) * SLIDER_STEP), 0).perform();
//            logs.add(String.format("(To):%s link clicked",rightPosition));
//            logs.add(String.format("(From):%s link clicked",leftPosition));
//        }
    }

    public void checkLogs() {
        int length = webLogs.size();
        for (int i = 0; i < length; i++) {
            webLogs.get(i).shouldHave(text(logs.get(length - i - 1)));
        }
    }
}
