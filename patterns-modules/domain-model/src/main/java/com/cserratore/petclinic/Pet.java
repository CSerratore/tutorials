package com.cserratore.petclinic;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

class Pet implements Entity {

    Pet(PetId id) {
        this.state = PetState.identifiedBy(id);
    }
    
    void register(
        PetTypeId petTypeId,
        Name name,
        LocalDate dateOfBirth, 
        OwnerId ownerId) {
        
        this.state = state.register(petTypeId, name, dateOfBirth, ownerId);
    }

    PetId id(){
        return this.state.id();
    }

    Optional<Instant> registeredAt() {
        return Optional.ofNullable(this.state.registeredAt());
    }

    private PetState state;

}
