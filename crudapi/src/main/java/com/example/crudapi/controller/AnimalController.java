package com.example.crudapi.controller;

import com.example.crudapi.entity.Animal;
import com.example.crudapi.repository.AnimalRepository;
import com.example.crudapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        model.addAttribute("AnimalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    @PostMapping("/new")
    public String addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.getAnimalById(id));
        return "animal-update";
    }

    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animals/" + animal.getAnimalId();
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable int id) {
        service.deleteAnimalById(id);
        return "redirect:/animals/all";
    }

    @GetMapping("/animal/{id}")
    public String getAnimalById(@PathVariable int id, Model model) {
        model.addAttribute("animal", service.getAnimalById(id));
        model.addAttribute("name", id);
        return "animal-details";
    }
}