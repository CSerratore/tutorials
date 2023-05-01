package com.cserratore.petclinic;

import java.util.Collection;
import java.util.stream.Collectors;

public class PetTypeUseCases implements ApplicationService {

    public AddPetTypeResponse addPetType(final AddPetTypeCommand command) {
        final PetType petType = PetClinicService.addPetType(
            new Name(command.name()));
        petTypeRepository.add(petType);

        final AddPetTypeResponse response = new AddPetTypeResponse(petType.id().value());
        return response;
    }

    public PetTypeResponse queryPetTypeById(QueryPetTypeById query) {
        final PetType petType = petTypeRepository.findById(new PetTypeId(query.petTypeId()));

        return new PetTypeResponse(petType.id().toString(), petType.name().value());
    }

    public Collection<PetTypeResponse> queryPetTypes() {
        Collection<PetType> petTypes = petTypeRepository.findAll();
        
        final Collection<PetTypeResponse> response = petTypes
            .stream()
            .map(s -> new PetTypeResponse(
                s.id().value(),
                s.name().value()))
            .collect(Collectors.toList());
        return response;
    }

    public PetTypeUseCases(
        final PetTypeRepository petTypeRepository) {
            this.petTypeRepository = petTypeRepository;
        }

    
    private final PetTypeRepository petTypeRepository;
    
}
