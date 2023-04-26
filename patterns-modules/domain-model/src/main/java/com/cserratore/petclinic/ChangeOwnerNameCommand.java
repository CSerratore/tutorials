package com.cserratore.petclinic;

public record ChangeOwnerNameCommand(
    String ownerId,
    String firstName, 
    String lastName) {}
