package com.PetStore.PetStore.repository;

import com.PetStore.PetStore.model.Pet;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
