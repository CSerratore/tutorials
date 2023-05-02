package com.cserratore.petclinic;

import java.util.Collection;
import java.util.stream.Collectors;

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

    public Collection<VetResponse> queryAllVets() {
        final Collection<Vet> vets = vetRepository.findAll();

        final Collection<VetResponse> response = vets
            .stream()
            .map(s -> new VetResponse(
                s.id().value(),
                s.name().firstName(),
                s.name().lastName()))
            .collect(Collectors.toList());
        return response;
    }

    public void changeVetName(final ChangeVetNameCommand command) {
        final Vet vet = vetRepository.findById(new VetId(command.vetId()));
        vet.changeName(new PersonName(command.firstName(), command.lastName()));
    }

    private VetRepository vetRepository;
    
}
