package com.springframework.springbootpetclinic.services.springdatajpa;

import com.springframework.springbootpetclinic.repositories.OwnerRepository;
import com.springframework.springbootpetclinic.repositories.PetRepository;
import com.springframework.springbootpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    OwnerRepository ownerRepository;
    PetRepository petRepository;
    PetTypeRepository petTypeRepository;

    OwnerSDJpaService owner;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}