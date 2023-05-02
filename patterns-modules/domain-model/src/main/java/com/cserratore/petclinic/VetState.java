package com.cserratore.petclinic;

import java.time.Instant;

record VetState(
    VetId id, 
    PersonName name,
    Instant resignedAt) {

    static VetState identifiedBy(final VetId id) {
        return new VetState(id, null, null);
    }

    VetState add(PersonName name) {
        return new VetState(this.id, name, null);
    }

    VetState changeName(final PersonName name) {
        return new VetState(this.id, name, null);
    }

    VetState resign() {
        return new VetState(this.id, this.name, Instant.now());
    }

}
