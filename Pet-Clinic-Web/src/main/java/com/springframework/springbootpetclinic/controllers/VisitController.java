package com.springframework.springbootpetclinic.controllers;

import com.springframework.springbootpetclinic.model.Pet;
import com.springframework.springbootpetclinic.model.Visit;
import com.springframework.springbootpetclinic.services.PetService;
import com.springframework.springbootpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model){
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);
        return visit;
    }

    //Spring MVC calls method loadPetVisits() before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model){
        return "pets/createOrUpdateVisitForm";
    }

    //Spring MVC calls method loadPetVisits() before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if(result.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        }else{
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}