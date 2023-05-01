package com.cserratore.petclinic;

import java.util.Collection;
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
    
    @Override
    public Collection<PetType> findAll() {
        return petTypes.values();
    }

    
    private Map<PetTypeId, PetType> petTypes;
}
