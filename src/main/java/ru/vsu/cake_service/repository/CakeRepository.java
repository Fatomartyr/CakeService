package ru.vsu.cake_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cake_service.entity.Cake;

import java.util.List;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long> {
    @Query("SELECT c FROM Cake c WHERE c.name = :name")
    List<Cake> findCakesByName(String name);

    @Query("SELECT c FROM Cake c where c.category.name = :name")
    List<Cake> findCakesByCategory(String name);
}
