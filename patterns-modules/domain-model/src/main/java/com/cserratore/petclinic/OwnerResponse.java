package com.cserratore.petclinic;

public record OwnerResponse(
    String id,
    String firstName,
    String lastName,
    String phoneNumber,
    String addressStreet,
    String addressCity,
    String addressStateProvince,
    String addressPostalCode,
    String registeredAt,
    String suspendedAt) {}
