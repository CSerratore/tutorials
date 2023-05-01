package com.cserratore.petclinic;

interface VetRepository {
    
    void add(Vet vet);

    Vet findById(VetId id);
}
