package com.cserratore.petclinic;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UseCases implements ApplicationService {
    
    public RegisterOwnerResponse registerOwner(RegisterOwnerCommand command) {
        Owner owner = PetClinicService.registerOwner(
            new PersonName(command.firstName(), command.lastName()),
            new PhoneNumber(command.phoneNumber()),
            new PostalAddress(
                command.streetAddress(),
                command.city(),
                command.stateProvince(),
                command.postalCode()));
        ownerRepository.add(owner);

        RegisterOwnerResponse response = new RegisterOwnerResponse(owner.id().value());
        return response;
    }

    public OwnerByIdResponse queryOwnerById(QueryOwnerById query) {
        Owner owner = ownerRepository.findById(new OwnerId(query.ownerId()));

        OwnerByIdResponse response = new OwnerByIdResponse(
            owner.name().firstName(), 
            owner.name().lastName(), 
            owner.phoneNumber().value(), 
            owner.postalAddress().streetAddress(),
            owner.postalAddress().city(), 
            owner.postalAddress().stateProvince(), 
            owner.postalAddress().postalCode());
        return response;
    }

    public Collection<OwnerResponse> queryOwners(OwnersQuery query) {
        Collection<Owner> owners;
        if (query.lastName() != null) {
            owners = ownerRepository.findByLastName(query.lastName());
        } else {
            owners = ownerRepository.findAll();
        }

        Collection<OwnerResponse> response = owners.stream()
            .map(s -> new OwnerResponse(
                s.id().value(),
                s.name().firstName(),
                s.name().lastName(),
                s.phoneNumber().value(),
                s.postalAddress().streetAddress(),
                s.postalAddress().city(),
                s.postalAddress().stateProvince(),
                s.postalAddress().postalCode()))
            .collect(Collectors.toList());
        return response;
    }


    public UseCases(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    private OwnerRepository ownerRepository;
}
