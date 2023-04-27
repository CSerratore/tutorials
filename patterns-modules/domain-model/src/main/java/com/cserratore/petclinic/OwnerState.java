package com.cserratore.petclinic;

import java.time.Instant;

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
        final PersonName name,
        final PhoneNumber phoneNumber,
        final PostalAddress postalAddress) {

        return new OwnerState(this.id, name, phoneNumber, postalAddress, Instant.now(), null);
    }

    OwnerState changeName(final PersonName name) {
        return new OwnerState(this.id, name, this.phoneNumber, this.postalAddress, this.registeredAt, null);
    }

    OwnerState changePhoneNumber(final PhoneNumber phoneNumber) {
        return new OwnerState(this.id, this.name, phoneNumber, this.postalAddress, this.registeredAt, null);
    }

    OwnerState changePostalAddress(final PostalAddress postalAddress) {
        return new OwnerState(this.id, this.name, this.phoneNumber, postalAddress, this.registeredAt, null);
    }

    OwnerState suspend() {
        return new OwnerState(this.id, this.name, this.phoneNumber, this.postalAddress, this.registeredAt, Instant.now());
    }

    OwnerState reinstate() {
        return new OwnerState(this.id, this.name, this.phoneNumber, this.postalAddress, this.registeredAt, null);
    }

}


