package com.springframework.springbootpetclinic.bootstrap;

import com.springframework.springbootpetclinic.model.Owner;
import com.springframework.springbootpetclinic.model.PetType;
import com.springframework.springbootpetclinic.model.Vet;
import com.springframework.springbootpetclinic.services.OwnerService;
import com.springframework.springbootpetclinic.services.PetTypeService;
import com.springframework.springbootpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedPetType1 = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedPetType2 = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Tom");
        owner1.setLastName("Mitchel");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("An");
        owner2.setLastName("Looney");

        ownerService.save(owner2);

        System.out.println("Initialized Owners--------");

        Vet vet1 = new Vet();
        vet1.setFirstName("Samuel");
        vet1.setLastName("Rust");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Cool");

        vetService.save(vet2);

        System.out.println("Initialized Vets--------");

    }
}
