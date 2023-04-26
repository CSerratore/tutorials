package com.cserratore.petclinic;

public record RegisterOwnerCommand(
    String firstName,
    String lastName,
    String phoneNumber,
    String streetAddress,
    String city,
    String stateProvince,
    String postalCode) {}
