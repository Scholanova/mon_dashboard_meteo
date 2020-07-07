package com.schola.weatherforcast;


import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.DailyWeatherForecast;

/**
 * Implementation of WeatherData Interface.
 * This class is used to forecast weather.
 * @version 1.0
 * @see IWeatherData
 */
public class WeatherData implements IWeatherData{
    /**
     * OpenWeatherMap API object for weather forecasting
     */
    private OWMFactory owmFactory = new OWMFactory();

    /**
     * Implementation of interface method.
     * This method is returning object with information about current weather in city served as parameter.
     *
     * @param cityName this parameter is String type object consisting name of the city for which weather is extracted
     * @return CurrentWeather object which consists basic information about weather.
     *
     * @throws APIException
     */
    @Override
    public CurrentWeather weatherForCityWithName(String cityName) throws APIException
    {
        return owmFactory.create().currentWeatherByCityName(cityName);
    }

    /**
     * Implementation of interface method.
     * This method is returning object with information about current weather in city in specified country.
     * Information about city and country is served in parameters.
     *
     * @param cityName this parameter is String type object consisting name of the city for which weather is extracted
     * @param countryCode this parameter is OWM.Country object consisting information about
     *                    in which country city is located based on country code.
     * @return CurrentWeather object which consists basic information about weather.
     *
     * @throws APIException
     */
    @Override
    public CurrentWeather weatherForCityWithNameAndCountryCode(String cityName, OWM.Country countryCode)
            throws APIException
    {
        return owmFactory.create().currentWeatherByCityName(cityName, countryCode);
    }

    /**
     * Implementation of interface method.
     * This method is returning object with information about 5 or whatever day weather forecast in city served as parameter.
     *
     * @param cityName this parameter is String type object consisting name of the city for which weather is extracted
     * @param numberOfDays this parameter is Int type object consisting information about reach of forecast
     *
     * @return DailyWeatherForecast object which consists basic information about weather forecast for number of days.
     *
     * @throws APIException
     */
    @Override
    public DailyWeatherForecast fiveDaysForecastForCityWithName(String cityName, int numberOfDays)
            throws APIException
    {
        return owmFactory.create().dailyWeatherForecastByCityName(cityName, numberOfDays);
    }

    /**
     * Implementation of interface method.
     * This method is returning object with information about 5 or whatever day weather forecast in city in certain country
     * served as parameters.
     *
     * @param cityName this parameter is String type object consisting name of the city for which weather is extracted
     * @param numberOfDays this parameter is Int type object consisting information about reach of forecast
     * @param countryCode this parameter is OWM.Country object consisting information about
     *                    in which country city is located based on country code.
     *
     * @return DailyWeatherForecast object which consists basic information about weather forecast for number of days.
     *
     * @throws APIException
     */
    @Override
    public DailyWeatherForecast fiveDaysForecastForCityWithNameAndCountryCode(String cityName, int numberOfDays, OWM.Country countryCode)
            throws APIException
    {
        return owmFactory.create().dailyWeatherForecastByCityName(cityName,countryCode, numberOfDays);
    }
}


