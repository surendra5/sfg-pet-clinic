package com.springframeworkguru.sfgpetclinic.repositories;

import com.springframeworkguru.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
