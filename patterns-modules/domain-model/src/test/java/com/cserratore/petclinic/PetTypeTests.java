package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    
    @Test
    void testFindPetTypeByIdReturnsPetType() {

        // given
        final PetTypeUseCases usecases = new PetTypeUseCases(
            this.petTypeRepository);

        final AddPetTypeResponse addPetTypeResponse = usecases
            .addPetType(new AddPetTypeCommand(PET_TYPE_DOG_NAME));
        final String petTypeId = addPetTypeResponse.petTypeId();

        // when
        final PetTypeResponse response = usecases.queryPetTypeById(new QueryPetTypeById(petTypeId));

        // then
        assertEquals(PET_TYPE_DOG_NAME, response.name());
    }

}
