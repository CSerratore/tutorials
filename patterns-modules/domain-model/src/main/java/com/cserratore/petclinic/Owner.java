package com.cserratore.petclinic;

import java.time.Instant;
import java.util.Optional;

class Owner implements Entity {
    
    Owner(OwnerId id) {
        this.state = OwnerState.identifiedBy(id);
    }
    
    void register(
        PersonName name,
        PhoneNumber phoneNumber,
        PostalAddress postalAddress) {
        
        this.state = state.register(name, phoneNumber, postalAddress);
    }

    OwnerId id(){
        return this.state.id();
    }

    Optional<Instant> registeredAt() {
        return Optional.ofNullable(this.state.registeredAt());
    }

    Optional<Instant> suspendedAt() {
        return Optional.ofNullable(this.state.suspendedAt());
    }

    PersonName name() {
        return this.state.name();
    }

    PhoneNumber phoneNumber() {
        return this.state.phoneNumber();
    }

    PostalAddress postalAddress() {
        return this.state.postalAddress();
    }

    void changeName(PersonName name) {
        this.state = state.changeName(name);
    }

    void changePhoneNumber(PhoneNumber phoneNumber) {
        this.state = state.changePhoneNumber(phoneNumber);
    }

    void changePostalAddress(PostalAddress postalAddress) {
        this.state = state.changePostalAddress(postalAddress);
    }

    void suspend() {
        if (this.state.suspendedAt() != null) {
            throw new IllegalStateException("Owner already suspended");
        }
        this.state = state.suspend();
    }

    private OwnerState state;
}
