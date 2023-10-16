package com.workintech.s17d1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    public AnimalController(){
        animals = new HashMap<>();
        System.out.println("new animal!");
    }
    @GetMapping("/")
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id){
        return animals.get(id);
    }
    @PostMapping("/")
    public Animal postAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animals.get(animal.getId());
    }
    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, new Animal(id, animal.getName(), animal.getSpecies()));
        return animals.get(id);
    }
    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id){
        return animals.remove(id);
    }
}
