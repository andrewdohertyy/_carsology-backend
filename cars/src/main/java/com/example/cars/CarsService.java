package com.example.cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarsService {

    @Autowired
   CarsRepository carsRepository;

    // CREATE
    public void addCar(Cars cars) {
        carsRepository.save(cars);
    }

    // READ

    public Cars getCarById(long id) {
        Optional<Cars> cars = carsRepository.findById(id);
        if (cars.isEmpty()) {
            throw new CarNotFoundException();
        }
        return cars.get();
    }

    public Cars getRandomCar() {
        List<Cars> carsList = carsRepository.findAll();
        Random rand = new Random();
        return carsList.get(rand.nextInt(carsList.size()));
    }

    public List<Long> getCarsIds() {
        return carsRepository.getDistinctIds();
    }

    public List<String> getCarMakes() {
        List<Cars> carsList = carsRepository.findAll();
        return carsList
                .stream()
                .map(Cars::getMake)
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }

    // UPDATE
    public void updateCar(Cars newCar, long id) {
        if (!carsRepository.existsById(id)) {
            throw new CarNotFoundException();
        }
        newCar.setId(id);
        carsRepository.save(newCar);
    }

    // DELETE
    @Transactional
    public void deleteCarById(long id) {
        if (!carsRepository.existsById(id)) {
            throw new CarNotFoundException();
        }
        carsRepository.deleteCarById(id);
    }
}