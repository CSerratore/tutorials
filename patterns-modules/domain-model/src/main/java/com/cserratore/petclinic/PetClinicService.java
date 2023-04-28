package com.cserratore.petclinic;

import java.util.UUID;

class PetClinicService implements DomainService {

    static Owner registerOwner(
        PersonName name,
        PhoneNumber phoneNumber,
        PostalAddress postalAddress) {

        Owner owner = new Owner(new OwnerId(UUID.randomUUID().toString()));
        owner.register(name, phoneNumber, postalAddress);
        return owner;
    }
    
    static PetType addPetType(Name name) {
        PetType petType = new PetType(new PetTypeId(UUID.randomUUID().toString()));
        petType.add(name);
        return petType;
    }

}
