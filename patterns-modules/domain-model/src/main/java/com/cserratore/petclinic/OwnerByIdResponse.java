package com.cserratore.petclinic;

public record OwnerByIdResponse(
    String firstName,
    String lastName,
    String phoneNumber,
    String addressStreet,
    String addressCity,
    String addressStateProvince,
    String addressPostalCode) {}
