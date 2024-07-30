package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    List<Car> cars = new ArrayList<>();

    public CarController() {
        cars.add(new Car("Ford", 2018, "red"));
        cars.add(new Car("Mazda", 2017, "white"));
        cars.add(new Car("Opel", 2016, "blue"));
        cars.add(new Car("Volkswagen", 2015, "black"));
    }

    @GetMapping
    public String getCars(@RequestParam(defaultValue = "5") int count, Model model) {
        List<Car> carsList = cars.subList(0, Math.min(count, cars.size()));
        model.addAttribute("cars", carsList);
        return "cars";
    }
}
