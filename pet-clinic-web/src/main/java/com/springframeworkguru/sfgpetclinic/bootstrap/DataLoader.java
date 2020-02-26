package com.springframeworkguru.sfgpetclinic.bootstrap;

import com.springframeworkguru.sfgpetclinic.model.Owner;
import com.springframeworkguru.sfgpetclinic.model.PetType;
import com.springframeworkguru.sfgpetclinic.model.Vet;
import com.springframeworkguru.sfgpetclinic.services.OwnerService;
import com.springframeworkguru.sfgpetclinic.services.PetTypeService;
import com.springframeworkguru.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        //DOUBT:- petTypeService obj should a object of petTypeMapservice created with PetService Interface
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

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("suren");
        vet1.setLastName("dra");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("suren");
        vet2.setLastName("dra");
        vetService.save(vet2);

        System.out.println("Loaded vets....");

    }
}
