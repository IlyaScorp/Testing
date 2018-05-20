package com.spbstu.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum USER_DATA {
    LOGIN("epam"), PASSWORD("1234"), USER_NAME("PITER CHAILOVSKII");

    private String value;

    public String toString(){
        return value;
    }

}
