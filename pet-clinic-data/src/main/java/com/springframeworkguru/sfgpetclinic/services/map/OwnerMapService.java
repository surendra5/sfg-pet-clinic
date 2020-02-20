package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import com.springframeworkguru.sfgpetclinic.services.CRUDService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CRUDService<Owner, Long> {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void save(Owner owner) {
        super.save(owner.getId(),owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
