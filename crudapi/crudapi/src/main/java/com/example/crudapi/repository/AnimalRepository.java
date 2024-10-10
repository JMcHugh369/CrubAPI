package com.example.crudapi.repository;

import com.example.crudapi.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findBySpecies(String species);

    @Query("SELECT a FROM Animal a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Animal> findByNameContaining(String name);
}
