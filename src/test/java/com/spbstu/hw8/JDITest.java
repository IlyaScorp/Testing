package com.spbstu.hw8;

import com.epam.web.matcher.testng.Check;
import com.spbstu.JDIPages.JDISite;
import com.spbstu.JDIPages.entities.MetalsColorsData;
import com.spbstu.enums.HOME_PAGE;
import com.spbstu.enums.USER_DATA;

import static com.spbstu.utils.ResourceLoader.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.spbstu.JDIPages.JDISite.*;

public class JDITest extends JDITestInit {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {getData("data_2")},
                {getData("data_1")},
                {getData("data_3")},
                {getData("data_4")},
                {getData("data_5")}
        };
    }

    @Test(enabled = true)
    public static void entryTest() {
        homePage.open();
        homePage.login();
        homePage.checkOpened();
        homePage.profilePhoto.waitText(USER_DATA.USER_NAME.toString());
        new Check().areEquals(JDISite.homePage.headerMenu.getNames()
                .stream().anyMatch(a -> a.equals(HOME_PAGE.METALS_COLORS.getValue())), true);
        homePage.headerMenu.clickOn(HOME_PAGE.METALS_COLORS.getValue());
    }

    //TODO There are some question but I'll ask them when you come to uni
    //TODO Насчет библиотеки... Идея хорошая, только вот работает не очень то корректно.
    //TODO В попытках сделать все с помощью JDI без переопределения методов его классов потрачено достаточно времени.
    //TODO в итоге, jdi можно воспринимать не как самодостаточную библиотеку, а как конструктор,
    //TODO часть реализации которого работает, а другую, что не захотела заработать по-умолчанию, стоит доделать.
    //TODO В целом, наверно это ускорит тестирование, но ситауции, когда вызываешь метод, к примеру,
    //TODO uncheckAll(), а он наоборот все чекает подряд, несколько опечаливают.
    //TODO Работать с наверняка рабочими инструментами отклик от которых очевиден приятнее.
    //TODO Ненависть к JDI начала сходить на нет, когда я начал понимать, что допиливать его методы - это нормальная практика.
    //TODO Оно и понятно, сделать идеально рабочую библиотеку довольно сложно при наличии разнообразной вёрстки.

    @Test(dataProvider = "data")
    public static void test(MetalsColorsData metalsColorsData) {
        metalAndColors.submitForm(metalsColorsData);
        metalAndColors.checkResults(metalsColorsData);
    }
}
