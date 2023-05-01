package com.cserratore.petclinic;

public record RegisterPetCommand(
    String ownerId,
    String petTypeId,
    String petName,
    String dateOfBirth) {}
