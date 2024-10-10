package com.example.crudapi.service;

import com.example.crudapi.entity.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalInterface {
    List<Animal> getAllAnimals();
    Animal saveAnimal(Animal animal);
    Optional<Animal> getAnimalById(int id);
    Animal updateAnimal(int id, Animal animalDetails);
    void deleteAnimal(int id);
    List<Animal> getAnimalsBySpecies(String species);
    List<Animal> searchAnimalsByName(String name);
}
