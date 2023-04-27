package com.cserratore.petclinic;

public record RegisterPetCommand(
    String ownerId,
    String petName,
    String dateOfBirth) {}
