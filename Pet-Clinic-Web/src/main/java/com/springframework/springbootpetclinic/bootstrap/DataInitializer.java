package com.springframework.springbootpetclinic.bootstrap;

import com.springframework.springbootpetclinic.model.*;
import com.springframework.springbootpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;


    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                           SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
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
        Owner ownerSaved1 = ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("An");
        owner2.setLastName("Looney");
        owner2.setAddress("21 Fox Park");
        owner2.setCity("Cork");
        owner2.setTelephone("568942341");
        Owner ownerSaved2 = ownerService.save(owner2);

        System.out.println("Initialized Owners--------");


        Pet pet1 = new Pet();
        pet1.setPetType(savedPetType1);
        pet1.setOwner(ownerSaved1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Mikey");
        owner1.getPets().add(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedPetType2);
        pet2.setOwner(ownerSaved2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Mira");
        owner2.getPets().add(pet2);

        System.out.println("Initialized Pets--------");


        Visit dogVisit = new Visit();
        dogVisit.setPet(pet1);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Infected Ears");
        visitService.save(dogVisit);



        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);


        Vet vet1 = new Vet();
        vet1.setFirstName("Samuel");
        vet1.setLastName("Rust");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Amanda");
        vet2.setLastName("Cool");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Initialized Vets--------");
    }
}
