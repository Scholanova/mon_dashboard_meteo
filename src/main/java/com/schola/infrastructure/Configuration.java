package com.schola.infrastructure;


import org.springframework.context.annotation.Conditional;

@Conditional(value = {MockProfileCondition.class})
public class Configuration {
}
