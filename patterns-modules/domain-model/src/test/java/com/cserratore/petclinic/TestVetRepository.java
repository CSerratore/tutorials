package com.cserratore.petclinic;

import java.util.Collection;
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

    @Override
    public Vet findById(VetId id) {
        return vets.get(id);
    }

    @Override
    public Collection<Vet> findAll() {
        return vets.values();
    }
    


    private Map<VetId, Vet> vets;
}
