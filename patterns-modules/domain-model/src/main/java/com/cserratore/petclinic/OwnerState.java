package com.cserratore.petclinic;

record OwnerState(
    OwnerId id,
    PersonName name,
    PhoneNumber phoneNumber,
    PostalAddress postalAddress) {

    static OwnerState identifiedBy(final OwnerId id) {
        return new OwnerState(id, null, null, null);
    }

    OwnerState register(
        PersonName name,
        PhoneNumber phoneNumber,
        PostalAddress postalAddress) {

        return new OwnerState(this.id, name, phoneNumber, postalAddress);
    }

    OwnerState changeName(PersonName name) {
        return new OwnerState(this.id, name, this.phoneNumber, this.postalAddress);
    }

    OwnerState changePhoneNumber(PhoneNumber phoneNumber) {
        return new OwnerState(this.id, this.name, phoneNumber, this.postalAddress);
    }

    OwnerState changePostalAddress(PostalAddress postalAddress) {
        return new OwnerState(this.id, this.name, this.phoneNumber, postalAddress);
    }
}


