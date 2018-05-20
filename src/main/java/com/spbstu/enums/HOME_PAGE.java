package com.spbstu.enums;

import lombok.Getter;


@Getter
public enum HOME_PAGE {
    /*
     * 1) Выравнивание текста Ctrl+Alt+L
     * Всегда ли оно следует Code Convention? Мне показалоись некоторые вырвавнивания странные.
     *
     * 2) Много ли занимают места лишни переменные(в этом енаме их 3)?
     * Или лучше сделать один Object и потом приводить к нужному классу?
     * */
    MAIN_TITLE("EPAM FRAMEWORK WISHES…"),
    SECOND_TITLE("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT,"
            + " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA."
            + " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS"
            + " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN"
            + " REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    /*
     * К примеру здесь вторая строка находится под new String[], а вроде рекомендуемо,
     * чтоб началась под "To include good...". Не принципиально?
     * */
    TEXT(new String[]{"To include good practices\nand ideas from successful\nEPAM projec",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\n" +
                    "some external projects),\nwish to get more…"}),
    SERVICE(new String[]{"SUPPORT", "DATES", "COMPLEX TABLE", "SIMPLE TABLE",
            "TABLE WITH PAGES", "DIFFERENT ELEMENTS"}),
    ICONS(new String[]{"practise", "custom", "multi", "base"});


    private String value;
    private String[] arrValue;

    HOME_PAGE(String s) {
        this.value = s;
    }

    HOME_PAGE(String[] strings) {
        this.arrValue = strings;
    }
}
