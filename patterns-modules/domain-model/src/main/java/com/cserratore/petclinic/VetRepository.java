package com.cserratore.petclinic;

import java.util.Collection;

interface VetRepository {
    
    void add(Vet vet);

    Vet findById(VetId id);

    Collection<Vet> findAll();
}
