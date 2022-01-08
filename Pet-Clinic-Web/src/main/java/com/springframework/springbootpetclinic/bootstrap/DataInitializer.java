package com.springframework.springbootpetclinic.bootstrap;

import com.springframework.springbootpetclinic.model.Owner;
import com.springframework.springbootpetclinic.model.Pet;
import com.springframework.springbootpetclinic.model.PetType;
import com.springframework.springbootpetclinic.model.Vet;
import com.springframework.springbootpetclinic.services.OwnerService;
import com.springframework.springbootpetclinic.services.PetTypeService;
import com.springframework.springbootpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


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
        owner1.setAddress("4 View Lane");
        owner1.setCity("Dublin");
        owner1.setTelephone("12354367");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("An");
        owner2.setLastName("Looney");
        owner2.setAddress("21 Fox Park");
        owner2.setCity("Cork");
        owner2.setTelephone("568942341");
        ownerService.save(owner2);

        System.out.println("Initialized Owners--------");

        Pet pet1 = new Pet();
        pet1.setPetType(savedPetType1);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Mikey");
        owner1.getPets().add(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetType2);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Mira");
        owner2.getPets().add(pet2);

        System.out.println("Initialized Pets--------");

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
