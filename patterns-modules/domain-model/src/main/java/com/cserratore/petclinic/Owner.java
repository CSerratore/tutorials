package com.cserratore.petclinic;

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

    private OwnerState state;
}
