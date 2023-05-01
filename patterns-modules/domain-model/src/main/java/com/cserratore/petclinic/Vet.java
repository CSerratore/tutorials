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


    private VetState state;
    
}
