package com.cserratore.petclinic;

import java.time.Instant;
import java.time.LocalDate;

record PetState(
    PetId id,
    Name name,
    LocalDate dateOfBirth,
    Instant registeredAt,
    OwnerId ownerId) {
    
    static PetState identifiedBy(final PetId id) {
        return new PetState(id, null, null, null, null);
    }

    PetState register(Name name, LocalDate dateOfBirth, OwnerId ownerId) {
        return new PetState(this.id, name, dateOfBirth, Instant.now(), ownerId);
    }

}
