package com.example.library.configuration.profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("staging")
public class StagingProfile {
}
