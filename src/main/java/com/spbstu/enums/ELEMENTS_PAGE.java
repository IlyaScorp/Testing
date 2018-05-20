package com.spbstu.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ELEMENTS_PAGE {

    CHECK_BOXES(Arrays.asList("Water", "Earth", "Wind", "Fire")),
    RADIOS(Arrays.asList("Gold", "Silver", "Bronze", "Selen")),
    COLORS_DROPDOWN(Arrays.asList("Red", "Green", "Blue", "Yellow"));

    private Object value;

}
