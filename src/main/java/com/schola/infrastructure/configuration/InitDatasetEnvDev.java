package com.schola.infrastructure.configuration;


import org.springframework.context.annotation.Conditional;

@Conditional(value = {MockProfileCondition.class})
public class InitDatasetEnvDev {
}
