package com.example.crudapi.service;

import com.example.crudapi.entity.Animal;
import com.example.crudapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements AnimalInterface {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }

    @Override
    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    @Override
    public Animal updateAnimal(int id, Animal animalDetails) {
        Animal animal = animalRepository.findById(id).orElseThrow();
        animal.setName(animalDetails.getName());
        animal.setScientificName(animalDetails.getScientificName());
        animal.setSpecies(animalDetails.getSpecies());
        animal.setHabitat(animalDetails.getHabitat());
        animal.setDescription(animalDetails.getDescription());
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }
}
