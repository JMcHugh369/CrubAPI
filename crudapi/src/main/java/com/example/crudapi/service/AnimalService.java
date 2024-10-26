package com.example.crudapi.service;

import com.example.crudapi.entity.Animal;
import com.example.crudapi.repository.AnimalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository AnimalRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Animal> getAllAnimals() {
        return entityManager.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
    }

    public Animal getAnimalById(int id) {
        return AnimalRepository.findById(id).orElse(null);
    }

    public void addNewAnimal(Animal animal) {
        AnimalRepository.save(animal);
    }

    public void updateAnimal(int id, Animal animal) {
        Animal existing = getAnimalById(id);
        existing.setName(animal.getName());
        existing.setSpecies(animal.getSpecies());
        existing.setScientificName(animal.getScientificName());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());
        AnimalRepository.save(existing);
    }

    public void deleteAnimalById(int id) {
    AnimalRepository.deleteById(id);
    }
}