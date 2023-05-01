package com.cserratore.petclinic;

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


    private VetState state;
    
}
