package com.cserratore.petclinic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class TestOwnerRepository implements OwnerRepository {

    TestOwnerRepository() {
        this.ownersById = new HashMap<>();
    }

    @Override
    public void add(final Owner owner) {
        ownersById.put(owner.id(), owner);
    }

    @Override
    public Owner findById(final OwnerId id) {
        final Owner owner = ownersById.get(id)            ;
        return owner;
    }

    private final Map<OwnerId, Owner> ownersById;

    @Override
    public Collection<Owner> findAll() {
        return ownersById.values();
    }

    @Override
    public Collection<Owner> findByLastName(String lastName) {
        Collection<Owner> response = ownersById.values().stream()
        .filter(s -> s.name().lastName().equals(lastName))
        .collect(Collectors.toList());
        return response;
    }

}