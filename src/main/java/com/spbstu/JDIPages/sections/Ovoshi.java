package com.spbstu.JDIPages.sections;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.spbstu.enums.elements_page.OVOSHI;
import org.openqa.selenium.By;

public class Ovoshi extends CheckList<OVOSHI> {

    @Override
    public void uncheckAll() {
        Menu f = new Menu<>(By.cssSelector(".salad button"));
        this.select(((String) f.getOptions().get(0)).split(","));

    }

    public void expand() {
        new Element().get(By.id("salad-dropdown")).click();
    }

    //TODO спросите, почему Menu? Потому что с помощью этого класса удалось получить текстовое поле из кнопки.
    // как влияет наследуемый класс на способность находить элементы на стр с помошью FindBy?
    // Как влияет селектор класса ovoshiList на поиск элементов внутри класса?
}
