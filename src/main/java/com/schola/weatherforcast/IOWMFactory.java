package com.schola.weatherforcast;

import net.aksingh.owmjapis.core.OWM;

/**
 * @version 1.1
 * Interface for OpenWeatherMap (API) factory
 */

public interface IOWMFactory{
    /**
     * Interface prototype for object creation method for factor
     * @return OWM object
     */
    OWM create();

    /**
     * Interface prototype for object creation method for factor
     * @param apiKey - API key for your application from OpenWeatherMap.org
     * @return OWM object
     */
    OWM create(String apiKey);
}
