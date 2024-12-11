package com.nwboxed.simplespring;

import com.nwboxed.simplespring.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(String id) {
        return carRepository.findById(id);
    }

    public void deleteCarById(String id) {
        carRepository.deleteById(id);
    }
}
