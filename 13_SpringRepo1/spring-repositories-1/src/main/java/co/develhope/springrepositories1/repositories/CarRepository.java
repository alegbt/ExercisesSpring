package co.develhope.springrepositories1.repositories;

import co.develhope.springrepositories1.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
