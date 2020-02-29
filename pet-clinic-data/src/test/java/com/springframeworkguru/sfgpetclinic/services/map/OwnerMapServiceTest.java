package com.springframeworkguru.sfgpetclinic.services.map;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService( new PetMapService(),new PetTypeMapService());
        ownerMapService.save(Owner.builder().id(1L).build());
    }

    @Test
    void findById() {
       Owner owner = ownerMapService.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet =  ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void saveById() {
        Owner savedOwner = ownerMapService.save(Owner.builder().id(2L).build());
        assertEquals(2L, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(1L));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0, ownerMapService.findAll().size());
    }
}