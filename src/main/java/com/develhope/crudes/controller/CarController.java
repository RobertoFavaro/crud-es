package com.develhope.crudes.controller;

import com.develhope.crudes.entity.Car;
import com.develhope.crudes.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car carAdded = carService.addCar(car);
        return ResponseEntity.ok().body(carAdded);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Integer id){
        Car carRemoved = carService.removeCar(id);
        return ResponseEntity.ok().body(carRemoved);
    }
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> selectCarById(@PathVariable Integer id){
        Car carTaked = carService.returnCarById(id);
        return ResponseEntity.ok().body(carTaked);
    }
    @GetMapping("/allCars")
    public ResponseEntity<List<Car>> selectAllCars(){
        List<Car> allCar = carService.returnAllCars();
        return ResponseEntity.ok().body(allCar);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable Integer id){
        Car carUpdated = carService.updateCars(car,id);
        return ResponseEntity.ok().body(carUpdated);
    }
}
