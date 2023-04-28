package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PetTypeTests {

    private static final String PET_TYPE_DOG_NAME = "dog";
 
    private PetTypeRepository petTypeRepository = new TestPetTypeRepository();

    @Test
    void testAddPetTypeReturnsPetTypeId() {

        // given

        // when
        final PetTypeUseCases usecases = new PetTypeUseCases(this.petTypeRepository);
        final AddPetTypeCommand command = new AddPetTypeCommand(PET_TYPE_DOG_NAME);

        final AddPetTypeResponse response = usecases.addPetType(command);

        // then
        assertNotNull(response.petTypeId());
    }
    
}
