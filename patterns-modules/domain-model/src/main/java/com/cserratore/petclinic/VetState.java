package com.cserratore.petclinic;

record VetState(VetId id, PersonName name) {

    static VetState identifiedBy(final VetId id) {
        return new VetState(id, null);
    }

    VetState add(PersonName name) {
        return new VetState(this.id, name);
    }

    VetState changeName(final PersonName name) {
        return new VetState(this.id, name);
    }

}
