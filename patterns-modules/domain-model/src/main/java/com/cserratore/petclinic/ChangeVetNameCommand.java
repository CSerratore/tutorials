package com.cserratore.petclinic;

public record ChangeVetNameCommand(
    String vetId,
    String firstName,
    String lastName)     {}
