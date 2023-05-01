package com.cserratore.petclinic;

interface PetTypeRepository {

    void add(PetType petType);

    PetType findById(PetTypeId id);
    
}
