package com.schola.infrastructure.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public abstract class ProfileCondition extends SpringBootCondition {
    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if(matchProfiles(context.getEnvironment())){
            return ConditionOutcome.match("A dev profile has been found.");
        }
        return ConditionOutcome.noMatch("No dev profiles found.");
    }

    protected abstract boolean matchProfiles(final Environment environment);
}
