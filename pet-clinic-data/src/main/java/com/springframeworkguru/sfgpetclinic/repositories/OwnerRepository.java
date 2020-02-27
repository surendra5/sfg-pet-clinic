package com.springframeworkguru.sfgpetclinic.repositories;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
