package com.cserratore.petclinic;

public record ChangeOwnerPostalAddressCommand(
    String ownerId,
    String addressStreet,
    String addressCity,
    String addressStateProvince,
    String addressPostalCode) {
}
