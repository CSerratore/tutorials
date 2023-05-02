package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class VetTests {
    
    private static final String VET_FIRST_NAME = "James";
    private static final String VET_LAST_NAME = "Carter";
    private static final String VET2_FIRST_NAME = "Helen";
    private static final String VET2_LAST_NAME = "Leary";
    private static final String VET3_FIRST_NAME = "Linda";
    private static final String VET3_LAST_NAME = "Douglas";

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

    @Test
    void findVetByIdReturnsOwner() {

        // given 
        final VetUseCases usecases = new VetUseCases(this.VetRepository);
        final AddVetResponse addVetResponse = usecases
            .addVet(
                new AddVetCommand(
                    VET_FIRST_NAME,
                    VET_LAST_NAME));
        final String vetId = addVetResponse.vetId();

        // when
        final VetResponse response = usecases
            .queryVetById(new VetByIdQuery(vetId));


        // then
        assertEquals(VET_FIRST_NAME, response.firstName());
        assertEquals(VET_LAST_NAME, response.lastName());
    }

    @Test
    void testListVets() {

        // given
        final VetUseCases usecases = new VetUseCases(this.VetRepository);
        usecases
            .addVet(
                new AddVetCommand(
                    VET_FIRST_NAME,
                    VET_LAST_NAME));

        usecases
            .addVet(
                new AddVetCommand(
                    VET2_FIRST_NAME,
                    VET2_LAST_NAME));

        usecases
            .addVet(
                new AddVetCommand(
                    VET3_FIRST_NAME,
                    VET3_LAST_NAME));
        

        // when
        final Collection<VetResponse> response = usecases
            .queryAllVets();

        // then
        assertEquals(3, response.size());
    }

    @Test
    void testChangeVetName() {

        // given
        final VetUseCases usecases = new VetUseCases(this.VetRepository);
        final AddVetResponse addVetResponse = usecases
            .addVet(
                new AddVetCommand(
                    VET_FIRST_NAME,
                    VET_LAST_NAME));
       final String vetId = addVetResponse.vetId();
       final String vetNewLastName = "Carter-Smith";

        // when
        usecases.changeVetName(new ChangeVetNameCommand(
            vetId,
            VET_FIRST_NAME,
            vetNewLastName));
        
        final VetResponse response = usecases
            .queryVetById(new VetByIdQuery(vetId));

        // then
        assertEquals(vetNewLastName, response.lastName());
    }

    @Test
    void testResignVet() {

        // given
        final VetUseCases usecases = new VetUseCases(this.VetRepository);
        final AddVetResponse addVetResponse = usecases
            .addVet(
                new AddVetCommand(
                    VET_FIRST_NAME,
                    VET_LAST_NAME));
       final String vetId = addVetResponse.vetId();

        // when
        usecases.resignVet(new ResignVetCommand(vetId));
        final VetResponse response = usecases.queryVetById(new VetByIdQuery(vetId));

        // then
        assertNotNull(response.resignedAt());
    }
}
