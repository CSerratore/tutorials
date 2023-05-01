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


    @Override
    public PetType findById(PetTypeId id) {
        return petTypes.get(id);
    }

    
    private Map<PetTypeId, PetType> petTypes;
}
