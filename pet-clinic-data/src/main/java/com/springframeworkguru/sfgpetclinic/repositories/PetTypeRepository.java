package com.springframeworkguru.sfgpetclinic.repositories;

import com.springframeworkguru.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
