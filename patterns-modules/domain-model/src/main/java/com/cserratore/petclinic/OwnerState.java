package com.cserratore.petclinic;

import java.time.Instant;
import java.util.Optional;

record OwnerState(
    OwnerId id,
    PersonName name,
    PhoneNumber phoneNumber,
    PostalAddress postalAddress,
    Instant registeredAt,
    Instant suspendedAt) {

    static OwnerState identifiedBy(final OwnerId id) {
        return new OwnerState(id, null, null, null, null, null);
    }

    OwnerState register(
        PersonName name,
        PhoneNumber phoneNumber,
        PostalAddress postalAddress) {

        return new OwnerState(this.id, name, phoneNumber, postalAddress, Instant.now(), null);
    }

    OwnerState changeName(PersonName name) {
        return new OwnerState(this.id, name, this.phoneNumber, this.postalAddress, this.registeredAt, null);
    }

    OwnerState changePhoneNumber(PhoneNumber phoneNumber) {
        return new OwnerState(this.id, this.name, phoneNumber, this.postalAddress, this.registeredAt, null);
    }

    OwnerState changePostalAddress(PostalAddress postalAddress) {
        return new OwnerState(this.id, this.name, this.phoneNumber, postalAddress, this.registeredAt, null);
    }

    OwnerState suspend() {
        return new OwnerState(this.id, this.name, this.phoneNumber, this.postalAddress, this.registeredAt, Instant.now());
    }

}


