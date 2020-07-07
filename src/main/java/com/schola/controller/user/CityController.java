package com.schola.controller.user;


import com.schola.entity.city.City;
import com.schola.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CityController {


    private CityService cityService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }


    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("cities", cityService.listAllCities());
        System.out.println("Returning cities:");
        return "cities";
    }


    @RequestMapping("city/{id}")
    public String showCity(@PathVariable Integer id, Model model) {
        model.addAttribute("city", cityService.getCityById(id));

        City myCity = new City();
        myCity = cityService.getCityById(id);
        System.out.println(myCity.getCityName());

        return "cityshow";
    }

    // Afficher le formulaire de modification du City
    @RequestMapping("city/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("city", cityService.getCityById(id));
        return "cityform";
    }


    @RequestMapping("city/new")
    public String newCity(Model model) {
        model.addAttribute("city", new City());
        return "cityform";
    }


    @RequestMapping(value = "city", method = RequestMethod.POST)
    public String saveCity(City city) {
        cityService.saveCity(city);
        return "redirect:/city/" + city.getId();
    }


    @RequestMapping("city/delete/{id}")
    public String delete(@PathVariable Integer id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }

}
