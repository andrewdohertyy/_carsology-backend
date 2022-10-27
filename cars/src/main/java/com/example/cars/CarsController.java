package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CarsController {


    @Autowired
    CarsService carsService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(CarNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


    // CREATE

    @PostMapping("/car")
    public ResponseEntity<Cars> createCar(@RequestBody Cars cars) {
        carsService.addCar(cars);
        return ResponseEntity.status(HttpStatus.CREATED).body(cars);
    }

    // READ

    @GetMapping("/hello")
    public ResponseEntity<String> car() {
        return ResponseEntity.status(HttpStatus.OK).body("Hello Car World!");
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Cars>> getCars() {
        return ResponseEntity.status(HttpStatus.OK).body(carsService.getAllCars());
    }

    @GetMapping("/cars/ids")
    public ResponseEntity<List<Long>> getCarsIds() {
        return ResponseEntity.status(HttpStatus.OK).body(carsService.getCarsIds());
    }

    @GetMapping("/cars/makes")
    public ResponseEntity<List<String>> getCarMakes() {
        return ResponseEntity.status(HttpStatus.OK).body(carsService.getCarMakes());
    }

    @GetMapping("/cars/random")
    public ResponseEntity<Cars> getRandomCar() {
        return ResponseEntity.status(HttpStatus.OK).body(carsService.getRandomCar());
    }


    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(carsService.getCarById(id));
    }

    // UPDATE

    @PutMapping("/cars/{id}")
    public ResponseEntity<Cars> updateCar(@RequestBody Cars newCar, @PathVariable long id) {
        newCar.setId(id);
        carsService.updateCar(newCar, id);
        return ResponseEntity.status(HttpStatus.OK).body(newCar);
    }

    // DELETE

    @DeleteMapping("/cars/{id}")
    @Transactional
    public ResponseEntity<String> deleteCarById(@PathVariable long id) {
        carsService.deleteCarById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
