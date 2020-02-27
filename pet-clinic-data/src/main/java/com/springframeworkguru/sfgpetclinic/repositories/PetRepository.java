package com.springframeworkguru.sfgpetclinic.repositories;

import com.springframeworkguru.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
