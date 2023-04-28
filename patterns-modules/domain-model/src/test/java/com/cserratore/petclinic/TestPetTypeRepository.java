package com.cserratore.petclinic;

import java.util.HashMap;
import java.util.Map;

public class TestPetTypeRepository implements PetTypeRepository {

    TestPetTypeRepository() {
        this.petTypes = new HashMap<>();
    }

    @Override
    public void add(PetType petType) {
        petTypes.put(petType.id(), petType);
    }

    
    private Map<PetTypeId, PetType> petTypes;
}
