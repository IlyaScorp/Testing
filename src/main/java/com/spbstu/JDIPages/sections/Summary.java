package com.spbstu.JDIPages.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.spbstu.JDIPages.sections.enums.RADIOS_FIRST;
import com.spbstu.JDIPages.sections.enums.RADIOS_LAST;


public class Summary extends Section {


    @JFindBy(css = "#odds-selector p")
    public RadioButtons<RADIOS_FIRST> boxFirst;

    @JFindBy(css = "#even-selector p")
    public RadioButtons<RADIOS_LAST> boxLast;

    @JFindBy(id = "calculate-button")
    public Button calculate;


}
