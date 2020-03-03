package com.springframeworkguru.sfgpetclinic.services.springdatajpa;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import com.springframeworkguru.sfgpetclinic.repositories.OwnerRepository;
import com.springframeworkguru.sfgpetclinic.repositories.PetRepository;
import com.springframeworkguru.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName("smith").build();
    }


    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerSDJpaService.findByLastName("smith");
        assertEquals("smith", smith.getLastName());
        verify(ownerRepository,times(1)).findByLastName(any());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(owners);

        assertNotNull(ownerSDJpaService.findAll());
        verify(ownerRepository,times(1)).findAll();
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(Owner.builder().id(5L).build());

        Owner savedOwner = ownerSDJpaService.save(any());
        assertEquals(5L, savedOwner.getId());
        verify(ownerRepository,times(1)).save(any());
    }

    @Test
    void delete() {
      ownerSDJpaService.delete(returnOwner);
      //default is 1
      verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}