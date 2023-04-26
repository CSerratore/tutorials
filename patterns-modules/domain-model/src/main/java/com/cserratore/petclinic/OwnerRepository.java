package com.cserratore.petclinic;

import java.util.Collection;

interface OwnerRepository {

    void add(Owner owner);
    
    Owner findById(OwnerId id);

    Collection<Owner> findAll();

    Collection<Owner> findByLastName(String lastName);
    
}
