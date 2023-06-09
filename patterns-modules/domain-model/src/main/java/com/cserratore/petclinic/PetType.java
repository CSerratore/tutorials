package com.cserratore.petclinic;

class PetType implements Entity {

    PetType(PetTypeId id) {
        this.state = PetTypeState.identifiedBy(id);
    }
    
    void add(
        Name name) {
        this.state = state.add(name);
    }

    PetTypeId id(){
        return this.state.id();
    }

    Name name() {
        return this.state.name();
    }


    private PetTypeState state;
}
