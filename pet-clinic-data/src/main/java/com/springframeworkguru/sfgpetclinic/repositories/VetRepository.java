package com.springframeworkguru.sfgpetclinic.repositories;

import com.springframeworkguru.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long > {
}
