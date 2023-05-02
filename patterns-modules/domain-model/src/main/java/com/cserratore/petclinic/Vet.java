package com.cserratore.petclinic;

import java.time.Instant;
import java.util.Optional;

public class Vet implements Entity {

    Vet(VetId id) {
        this.state = VetState.identifiedBy(id);
    }

    void add(PersonName name) {

        this.state = state.add(name);
    }

    VetId id() {
        return this.state.id();
    }

    PersonName name() {
        return this.state.name();
    }

    void changeName(PersonName name) {
        this.state = state.changeName(name);
    }

    void resign() {
        this.state = state.resign();
    }

    Optional<Instant> resignedAt() {
        return Optional.ofNullable(this.state.resignedAt());
    }


    private VetState state;
    
}
