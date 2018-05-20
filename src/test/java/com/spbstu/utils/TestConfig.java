package com.spbstu.utils;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:data.properties"
})

public interface TestConfig extends Config {

    @Key("icons")
    String[] icons();

    @Key("titles")
    String[] titles();

    @Key("main.title")
    String mainTitle();

    @Key("second.title")
    String secondTitle();

}
