package com.cserratore.petclinic;

import java.time.Instant;
import java.time.LocalDate;

record PetState(
    PetId id,
    PetTypeId petTypeId,
    Name name,
    LocalDate dateOfBirth,
    Instant registeredAt,
    OwnerId ownerId) {
    
    static PetState identifiedBy(final PetId id) {
        return new PetState(id, null, null, null, null, null);
    }

    PetState register(PetTypeId petTypeId, Name name, LocalDate dateOfBirth, OwnerId ownerId) {
        return new PetState(this.id, petTypeId, name, dateOfBirth, Instant.now(), ownerId);
    }

}
