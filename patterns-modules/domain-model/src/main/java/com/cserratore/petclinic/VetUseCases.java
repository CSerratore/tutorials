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

    public VetResponse queryVetById(final VetByIdQuery query) {
        Vet vet = vetRepository.findById(new VetId(query.vetId()));
        return new VetResponse(
            vet.id().value(),
            vet.name().firstName(),
            vet.name().lastName());
    }


    private VetRepository vetRepository;
    
}
