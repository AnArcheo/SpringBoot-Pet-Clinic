package com.springframework.springbootpetclinic.services.map;

import com.springframework.springbootpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }
// save owner with Id
    @Test
    void save() {
        Long ownerId2 = 2L;
        Owner owner2 = Owner.builder().id(ownerId2).build();
        Owner savedOwner2 = ownerServiceMap.save(owner2);
        assertEquals(ownerId2, savedOwner2.getId());
    }
    // save owner with Id
    @Test
    void saveWithoutId() {
        Owner savedOwner3 = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner3);
        assertNotNull(savedOwner3.getId());
    }
    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner ownerLastName = ownerServiceMap.findByLastName(lastName);
        assertNotNull(ownerLastName);
        assertEquals(ownerId, ownerLastName.getId());
    }

    @Test
    void findByLastNameIsNull() {
        Owner ownerLastName = ownerServiceMap.findByLastName("Boo");
        assertNull(ownerLastName);
    }
}