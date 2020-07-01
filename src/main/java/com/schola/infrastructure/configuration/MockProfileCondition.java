package com.schola.infrastructure.configuration;

import org.springframework.core.env.Environment;

import java.util.Arrays;

public class MockProfileCondition extends ProfileCondition {
    @Override
    protected boolean matchProfiles(Environment environment) {
        return Arrays.stream(environment.getActiveProfiles()).anyMatch("dev"::equals);
    }
}
