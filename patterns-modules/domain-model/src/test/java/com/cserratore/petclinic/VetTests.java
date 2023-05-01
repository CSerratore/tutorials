package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class VetTests {
    
    private static final String VET_FIRST_NAME = "James";
    private static final String VET_LAST_NAME = "Carter";

    private final VetRepository VetRepository = new TestVetRepository();
    

    @Test
    void addVestReturnsVetId() {

        // given

        // when
        final VetUseCases usecases = new VetUseCases(this.VetRepository);
        final AddVetResponse response = usecases
            .addVet(
                new AddVetCommand(
                    VET_FIRST_NAME,
                    VET_LAST_NAME));
        
        // then
        assertNotNull(response.vetId());
    }
}
