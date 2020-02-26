package com.springframeworkguru.sfgpetclinic.bootstrap;

import com.springframeworkguru.sfgpetclinic.model.*;
import com.springframeworkguru.sfgpetclinic.services.OwnerService;
import com.springframeworkguru.sfgpetclinic.services.PetTypeService;
import com.springframeworkguru.sfgpetclinic.services.SpecialityService;
import com.springframeworkguru.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        //DOUBT:- petTypeService obj should be a object of petTypeMapservice created with PetService Interface
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("surendra");
        owner1.setLastName("meena");
        owner1.setAddress("palam vihar");
        owner1.setCity("gurgoan");
        owner1.setTelephone("12131212121");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("surendra2");
        owner2.setLastName("meena2");
        owner2.setAddress("palam vihar");
        owner2.setCity("gurgoan");
        owner2.setTelephone("12131212121");
        ownerService.save(owner2);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("sheru");
        owner1.getPets().add(mikesPet);

        Pet surendraPet = new Pet();
        surendraPet.setPetType(savedCatPetType);
        surendraPet.setOwner(owner1);
        surendraPet.setBirthDate(LocalDate.now());
        surendraPet.setName("billi");
        owner1.getPets().add(surendraPet);

        System.out.println("Loaded owners....");

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology specilist");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        radiology.setDescription("denstistry specilist");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        radiology.setDescription("surgery specilist");
        Speciality savedSurgery = specialityService.save(surgery);

        Vet vet1 = new Vet();
        vet1.setFirstName("suren");
        vet1.setLastName("dra");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("suren");
        vet2.setLastName("dra");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedDentistry);

        System.out.println("Loaded vets....");
    }
}
