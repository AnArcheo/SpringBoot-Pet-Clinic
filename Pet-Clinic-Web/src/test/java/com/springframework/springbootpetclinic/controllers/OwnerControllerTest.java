package com.springframework.springbootpetclinic.controllers;

import com.springframework.springbootpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnerController ownerController;


    @BeforeEach
    void setUp() {
    }

    @Test
    void listOfOwners() {
    }

    @Test
    void findOwners() {
    }
}