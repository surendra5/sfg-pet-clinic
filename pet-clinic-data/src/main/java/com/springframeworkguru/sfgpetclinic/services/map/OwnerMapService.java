package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import com.springframeworkguru.sfgpetclinic.services.OwnerService;
import com.springframeworkguru.sfgpetclinic.services.PetService;
import com.springframeworkguru.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        if(owner != null) {
            //generating and saving pet ID
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("pet type required");
                    }
                });
            }
            return super.save(owner);
        }
            else{
                return null;
        }

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
