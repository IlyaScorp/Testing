package com.spbstu.JDIPages.sections.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RADIOS_FIRST {
    ONE("1"),
    THREE("3"),
    FIVE("5"),
    SEVEN("7");

    private String value;

//    RADIOS_FIRST(String value) { this.value = value;}

}
