package com.cserratore.petclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class RegisterOwnerTests {
    
    private static final String OWNER_FIRST_NAME = "John";
    private static final String OWNER_LAST_NAME = "Doe";
    private static final String OWNER_PHONE_NUMBER = "555-336-1262";
    private static final String OWNER_ADDRESS_STREET = "123 Main Street";
    private static final String OWNER_ADDRESS_CITY = "Gotham";
    private static final String OWNER_ADDRESS_STATE_PROVINCE = "ON";
    private static final String OWNER_ADDRESS_POSTAL_CODE = "L7T 7R1";

    private static final String OWNER2_FIRST_NAME = "Jane";
    private static final String OWNER2_LAST_NAME = "Doe";
    private static final String OWNER2_PHONE_NUMBER = "555-436-1265";
    private static final String OWNER2_ADDRESS_STREET = "123 Main Street";
    private static final String OWNER2_ADDRESS_CITY = "Gotham";
    private static final String OWNER2_ADDRESS_STATE_PROVINCE = "ON";
    private static final String OWNER2_ADDRESS_POSTAL_CODE = "L7T 7R1";

    private static final String OWNER3_FIRST_NAME = "Jack";
    private static final String OWNER3_LAST_NAME = "Smith";
    private static final String OWNER3_PHONE_NUMBER = "555-888-1212";
    private static final String OWNER3_ADDRESS_STREET = "935 Adelaide Street";
    private static final String OWNER3_ADDRESS_CITY = "Gotham";
    private static final String OWNER3_ADDRESS_STATE_PROVINCE = "ON";
    private static final String OWNER3_ADDRESS_POSTAL_CODE = "L7Y 7T3";

    private final OwnerRepository ownerRepository = new TestOwnerRepository();

    @Test
    void testRegisterOwnerReturnsOwnerId() {

        // given

        // when 
        final UseCases usecases = new UseCases(this.ownerRepository);
        final RegisterOwnerCommand command = new RegisterOwnerCommand(
            OWNER_FIRST_NAME, 
            OWNER_LAST_NAME, 
            OWNER_PHONE_NUMBER, 
            OWNER_ADDRESS_STREET, 
            OWNER_ADDRESS_CITY, 
            OWNER_ADDRESS_STATE_PROVINCE, 
            OWNER_ADDRESS_POSTAL_CODE);

        final RegisterOwnerResponse response = usecases.registerOwner(command);

        // then
        assertNotNull(response.ownerId());
    }

    @Test
    void testFindOwnerByIdReturnsOwner() {

        // given
        final UseCases usecases = new UseCases(this.ownerRepository);
        final RegisterOwnerCommand command = new RegisterOwnerCommand(
            OWNER_FIRST_NAME, 
            OWNER_LAST_NAME, 
            OWNER_PHONE_NUMBER, 
            OWNER_ADDRESS_STREET, 
            OWNER_ADDRESS_CITY, 
            OWNER_ADDRESS_STATE_PROVINCE, 
            OWNER_ADDRESS_POSTAL_CODE);

        final RegisterOwnerResponse registerOwnerResponse = usecases.registerOwner(command);
        final String ownerId = registerOwnerResponse.ownerId();

        // when
        final QueryOwnerById query = new QueryOwnerById(ownerId);

        final OwnerByIdResponse response = usecases.queryOwnerById(query);

        // then
        assertEquals(OWNER_FIRST_NAME, response.firstName());
        assertEquals(OWNER_LAST_NAME, response.lastName());
        assertEquals(OWNER_PHONE_NUMBER, response.phoneNumber());
        assertEquals(OWNER_ADDRESS_STREET, response.addressStreet());
        assertEquals(OWNER_ADDRESS_CITY, response.addressCity());
        assertEquals(OWNER_ADDRESS_STATE_PROVINCE, response.addressStateProvince());
        assertEquals(OWNER_ADDRESS_POSTAL_CODE, response.addressPostalCode());
    }

    @Test
    void testListOwners() {
        // given
        final UseCases usecases = new UseCases(this.ownerRepository);
        final RegisterOwnerCommand command = new RegisterOwnerCommand(
            OWNER_FIRST_NAME, 
            OWNER_LAST_NAME, 
            OWNER_PHONE_NUMBER, 
            OWNER_ADDRESS_STREET, 
            OWNER_ADDRESS_CITY, 
            OWNER_ADDRESS_STATE_PROVINCE, 
            OWNER_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command);

        final RegisterOwnerCommand command2 = new RegisterOwnerCommand(
            OWNER2_FIRST_NAME, 
            OWNER2_LAST_NAME, 
            OWNER2_PHONE_NUMBER, 
            OWNER2_ADDRESS_STREET, 
            OWNER2_ADDRESS_CITY, 
            OWNER2_ADDRESS_STATE_PROVINCE, 
            OWNER2_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command2);
        
        final RegisterOwnerCommand command3 = new RegisterOwnerCommand(
            OWNER3_FIRST_NAME, 
            OWNER3_LAST_NAME, 
            OWNER3_PHONE_NUMBER, 
            OWNER3_ADDRESS_STREET, 
            OWNER3_ADDRESS_CITY, 
            OWNER3_ADDRESS_STATE_PROVINCE, 
            OWNER3_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command3);
        
        // when
        final OwnersQuery query = new OwnersQuery(null);

        final Collection<OwnerResponse> response = usecases.queryOwners(query);


        // then
        assertEquals(3, response.size());
    }

    @Test
    void testListOwnersByLastName() {

        // given
        final UseCases usecases = new UseCases(this.ownerRepository);
        final RegisterOwnerCommand command = new RegisterOwnerCommand(
            OWNER_FIRST_NAME, 
            OWNER_LAST_NAME, 
            OWNER_PHONE_NUMBER, 
            OWNER_ADDRESS_STREET, 
            OWNER_ADDRESS_CITY, 
            OWNER_ADDRESS_STATE_PROVINCE, 
            OWNER_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command);

        final RegisterOwnerCommand command2 = new RegisterOwnerCommand(
            OWNER2_FIRST_NAME, 
            OWNER2_LAST_NAME, 
            OWNER2_PHONE_NUMBER, 
            OWNER2_ADDRESS_STREET, 
            OWNER2_ADDRESS_CITY, 
            OWNER2_ADDRESS_STATE_PROVINCE, 
            OWNER2_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command2);
        
        final RegisterOwnerCommand command3 = new RegisterOwnerCommand(
            OWNER3_FIRST_NAME, 
            OWNER3_LAST_NAME, 
            OWNER3_PHONE_NUMBER, 
            OWNER3_ADDRESS_STREET, 
            OWNER3_ADDRESS_CITY, 
            OWNER3_ADDRESS_STATE_PROVINCE, 
            OWNER3_ADDRESS_POSTAL_CODE);
        usecases.registerOwner(command3);
        
        // when
        final OwnersQuery query = new OwnersQuery(OWNER_LAST_NAME);

        final Collection<OwnerResponse> response = usecases.queryOwners(query);

        // then
        assertEquals(2, response.size());
    }
}
