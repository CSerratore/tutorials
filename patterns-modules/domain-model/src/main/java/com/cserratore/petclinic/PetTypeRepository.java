package com.cserratore.petclinic;

import java.util.Collection;

interface PetTypeRepository {

    void add(PetType petType);

    PetType findById(PetTypeId id);

    Collection<PetType> findAll();
}
