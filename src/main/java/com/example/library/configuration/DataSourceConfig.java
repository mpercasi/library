package com.example.library.configuration;

import org.springframework.stereotype.Component;

@Component
public interface DataSourceConfig {
    void setup();
}
