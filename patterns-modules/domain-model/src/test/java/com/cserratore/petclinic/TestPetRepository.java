package com.cserratore.petclinic;

import java.util.HashMap;
import java.util.Map;

class TestPetRepository implements PetRepository {

    TestPetRepository() {
        this.pets = new HashMap<>();
    }

    @Override
    public void add(Pet pet) {
        // TODO Auto-generated method stub
        
    }


    private Map<PetId, Pet> pets;
    
}
