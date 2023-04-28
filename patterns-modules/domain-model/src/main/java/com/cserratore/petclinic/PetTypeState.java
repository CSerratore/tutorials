package com.cserratore.petclinic;

record PetTypeState(PetTypeId id, Name name) {

    static PetTypeState identifiedBy(final PetTypeId id) {
        return new PetTypeState(id, null);
    }

    PetTypeState add(Name name) {
        return new PetTypeState(this.id, name);
    }

}
