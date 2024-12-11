package com.nwboxed.simplespring;

import com.nwboxed.simplespring.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // This will resolve index.html if using Thymeleaf or serve static content
    }

    @GetMapping("/cars")
    public List<Car> cars() {
        return carService.findAll();
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCarById(id).orElse(null);
    }

    @PostMapping("/car")
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable String id) {
        carService.deleteCarById(id);
    }
}
