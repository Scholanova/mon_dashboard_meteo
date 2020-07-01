package com.schola.infrastructure;

import org.springframework.context.annotation.Condition;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class MockProfileCondition extends ProfileCondition {
    @Override
    protected boolean matchProfiles(Environment environment) {
        return Arrays.stream(environment.getActiveProfiles()).anyMatch("dev"::equals);
    }
}
