package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Vet;
import com.springframeworkguru.sfgpetclinic.services.CRUDService;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements CRUDService<Vet, Long> {


    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void save(Vet vet) {
        super.save(vet.getId(), vet);
    }
}
