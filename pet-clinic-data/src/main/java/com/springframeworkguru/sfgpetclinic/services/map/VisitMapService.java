package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Visit;
import com.springframeworkguru.sfgpetclinic.services.VisitService;

import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null ||visit.getPet()==null || visit.getPet().getOwner()==null)
            throw new RuntimeException("Invalid Visit");

        return super.save(visit);
    }
}
