package com.cserratore.petclinic;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class UseCases implements ApplicationService {
    
    public RegisterOwnerResponse registerOwner(final RegisterOwnerCommand command) {
        final Owner owner = PetClinicService.registerOwner(
            new PersonName(command.firstName(), command.lastName()),
            new PhoneNumber(command.phoneNumber()),
            new PostalAddress(
                command.streetAddress(),
                command.city(),
                command.stateProvince(),
                command.postalCode()));
        ownerRepository.add(owner);

        final RegisterOwnerResponse response = new RegisterOwnerResponse(owner.id().value());
        return response;
    }

    public OwnerResponse queryOwnerById(final QueryOwnerById query) {
        final Owner owner = ownerRepository.findById(new OwnerId(query.ownerId()));

        final OwnerResponse response = new OwnerResponse(
            owner.id().toString(),
            owner.name().firstName(), 
            owner.name().lastName(), 
            owner.phoneNumber().value(), 
            owner.postalAddress().streetAddress(),
            owner.postalAddress().city(), 
            owner.postalAddress().stateProvince(), 
            owner.postalAddress().postalCode(),
            owner.registeredAt()
                .map(Instant::toString)
                .orElse(null),
            owner.suspendedAt()
                .map(Instant::toString)
                .orElse(null));
        return response;
    }

    public Collection<OwnerResponse> queryOwners(final OwnersQuery query) {
        Collection<Owner> owners;
        if (query.lastName() != null) {
            owners = ownerRepository.findByLastName(query.lastName());
        } else {
            owners = ownerRepository.findAll();
        }

        final Collection<OwnerResponse> response = owners.stream()
            .map(s -> new OwnerResponse(
                s.id().value(),
                s.name().firstName(),
                s.name().lastName(),
                s.phoneNumber().value(),
                s.postalAddress().streetAddress(),
                s.postalAddress().city(),
                s.postalAddress().stateProvince(),
                s.postalAddress().postalCode(),
                s.registeredAt()
                    .map(Instant::toString)
                    .orElse(null),
                s.suspendedAt()
                    .map(Instant::toString)
                    .orElse(null)))
            .collect(Collectors.toList());
        return response;
    }

    public void changeOwnerName(ChangeOwnerNameCommand command) {
        final Owner owner = ownerRepository.findById(new OwnerId(command.ownerId()));

        owner.changeName(new PersonName(command.firstName(), command.lastName()));
    }

    public void changeOwnerPhoneNumber(ChangeOwnerPhoneNumberCommand command) {
        final Owner owner = ownerRepository.findById(new OwnerId(command.ownerId()));

        owner.changePhoneNumber(new PhoneNumber(command.phoneNumber()));
    }

    public void changeOwnerPostalAddress(ChangeOwnerPostalAddressCommand command) {
        final Owner owner = ownerRepository.findById(new OwnerId(command.ownerId()));

        owner.changePostalAddress(
            new PostalAddress(
                command.addressStreet(), 
                command.addressCity(),
                command.addressStateProvince() ,
                command.addressPostalCode()));
    }

    public void suspendOwner(SuspendOwnerCommand command) {
        final Owner owner = ownerRepository.findById(new OwnerId(command.ownerId()));

        owner.suspend();
    }

    public void reinstateOwner(ReinstateOwnerCommand command) {
        final Owner owner = ownerRepository.findById(new OwnerId(command.ownerId()));

        owner.reinstate();
    }

    public UseCases(final OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    private final OwnerRepository ownerRepository;
}
