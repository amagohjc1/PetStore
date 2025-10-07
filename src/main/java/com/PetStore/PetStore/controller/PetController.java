package com.PetStore.PetStore.controller;

import com.PetStore.PetStore.model.Pet;
import com.PetStore.PetStore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/petStore/api")
public class PetController {

    @Autowired
    PetRepository petRepository;



    @PostMapping("/postPet") public ResponseEntity <Pet> postEmployee(@RequestBody Pet em){
        petRepository.save(em);
        return new ResponseEntity<>(em, HttpStatus.CREATED);
    }


    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getPets(){
        List<Pet> pets= petRepository.findAll();

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }


    @GetMapping("/pet/{id}")
    public ResponseEntity<Pet> getEmployeeById(@PathVariable long id){
        Pet pet= petRepository.findById(id).orElse(new Pet());

        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PutMapping("/updatePet/{id}") public ResponseEntity<Pet> updatePet(@PathVariable long id,@RequestBody Pet petDetails){

        Optional<Pet> pet= petRepository.findById(id);

        Pet updatedEmployee = petRepository.save(pet.orElse(null));

        return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("/deletePet/{id}") public ResponseEntity<Map<String, Boolean>> deletePet(@PathVariable long id){

        petRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }

}
