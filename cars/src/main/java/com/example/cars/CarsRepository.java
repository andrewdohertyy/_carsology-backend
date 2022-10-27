package com.example.cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long>{

        // READ

        @Query(value="SELECT DISTINCT id FROM cars ", nativeQuery = true)
        List<Long> getDistinctIds();

        @Query(value="SELECT * FROM cars ORDER BY RAND()", nativeQuery = true)
        Cars getRandomCar();


        // DELETE
        void deleteCarById(long id);
    }
