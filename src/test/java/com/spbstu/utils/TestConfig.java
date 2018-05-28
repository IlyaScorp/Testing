package com.spbstu.utils;


import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:data.properties"
})
public interface TestConfig extends Config {

    @Key("test.url")
    String url();
}
