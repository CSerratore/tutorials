package com.cserratore.petclinic;

public record ChangeOwnerPhoneNumberCommand(
    String ownerId,
    String phoneNumber) {}
