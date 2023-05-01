package com.cserratore.petclinic;

public class VetUseCases implements ApplicationService {

    public VetUseCases(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public AddVetResponse addVet(final AddVetCommand command) {
        final Vet vet = PetClinicService.addVet(
            new PersonName(command.firstName(), command.lastName()));
        vetRepository.add(vet);

        final AddVetResponse response = new AddVetResponse(vet.id().value());
        return response;
    }




    private VetRepository vetRepository;
    
}
