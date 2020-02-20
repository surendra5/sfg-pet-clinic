package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Pet;
import com.springframeworkguru.sfgpetclinic.services.CRUDService;

import java.util.Set;

public class PetMapService extends AbstractMapService<Pet, Long> implements CRUDService<Pet, Long> {


    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void save(Pet pet) {
        super.save(pet.getId(), pet);
    }
}
