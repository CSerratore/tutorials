package com.cserratore.petclinic;

public class PetTypeUseCases implements ApplicationService {

    public AddPetTypeResponse addPetType(final AddPetTypeCommand command) {
        final PetType petType = PetClinicService.addPetType(
            new Name(command.name()));
        petTypeRepository.add(petType);

        final AddPetTypeResponse response = new AddPetTypeResponse(petType.id().value());
        return response;
    }

    public PetTypeUseCases(
        final PetTypeRepository petTypeRepository) {
            this.petTypeRepository = petTypeRepository;
        }

    
    private final PetTypeRepository petTypeRepository;
    
}
