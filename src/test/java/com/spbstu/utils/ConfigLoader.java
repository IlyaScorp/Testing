package com.spbstu.utils;

import org.aeonbits.owner.ConfigFactory;

public class ConfigLoader {

    private static TestConfig config;

    public static TestConfig config() {
        if (config == null) {

            config = ConfigFactory.create(TestConfig.class);
        }
        return config;
    }

}
