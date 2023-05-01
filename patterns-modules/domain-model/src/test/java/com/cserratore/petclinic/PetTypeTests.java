package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class PetTypeTests {

    private static final String PET_TYPE_DOG_NAME = "dog";
    private static final String PET_TYPE_CAT_NAME = "cat";
    private static final String PET_TYPE_LIZARD_NAME = "lizard";
    private static final String PET_TYPE_BIRD_NAME = "bird";
    private static final String PET_TYPE_SNAKE_NAME = "snake";
 
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

    @Test
    void testListPetTypes() {

        // given
        final PetTypeUseCases usecases = new PetTypeUseCases(
            this.petTypeRepository);

        usecases.addPetType(new AddPetTypeCommand(PET_TYPE_DOG_NAME));
        usecases.addPetType(new AddPetTypeCommand(PET_TYPE_CAT_NAME));
        usecases.addPetType(new AddPetTypeCommand(PET_TYPE_LIZARD_NAME));
        usecases.addPetType(new AddPetTypeCommand(PET_TYPE_BIRD_NAME));
        usecases.addPetType(new AddPetTypeCommand(PET_TYPE_SNAKE_NAME));

        // when
        final Collection<PetTypeResponse> response = usecases
            .queryPetTypes();

        // then
        assertEquals(5, response.size());
    }

}
