package com.cserratore.petclinic;

import java.util.HashMap;
import java.util.Map;

class TestVetRepository implements VetRepository {

    TestVetRepository() {
        this.vets = new HashMap<>();
    }

    @Override
    public void add(Vet vet) {
        vets.put(vet.id(), vet);
    }


    private Map<VetId, Vet> vets;
}